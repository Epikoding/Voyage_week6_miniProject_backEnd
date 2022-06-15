package com.tenzo.mini_project2.security.jwt;



import com.tenzo.mini_project2.security.dto.HeaderResponseDto;
import com.tenzo.mini_project2.security.dto.RefreshTokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String REFRESH_HEADER = "RefreshToken";
    private static final String BEARER_TYPE = "Bearer";

    // secretKey 와 같은 민감정보는 숨기는 것이 좋다. (이것은 연습이라서 노출함)
    @Value("${jwt.secret}")
    private String secretKey;

    // 토큰 유효시간 5분 설정 (1000L = 1초, 1000L * 60 = 1분)
    private static final long TOKEN_VALID_TIME = 1000L * 60 * 5;

    private final UserDetailsService userDetailsService;
    // 객체 초기화, secretKey 를 Base64로 인코딩한다.
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성
    public HeaderResponseDto createToken(String userPk) {
        Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위
        Date now = new Date();
        String accessToken = Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_TIME)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과 signature 에 들어갈 secret값 세팅
                .compact();

        Date refreshTokenExpiresIn = new Date(now.getTime() + JwtSetting.ExpireTime.REFRESH_TOKEN_EXPIRE_TIME.getExpireTime());
        String refreshToken = Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return HeaderResponseDto.builder()
                .grantType(JwtSetting.HEADER_PREFIX.getSetting())
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN(refreshToken)
                .refreshTokenExpirationTime(JwtSetting.ExpireTime.REFRESH_TOKEN_EXPIRE_TIME.getExpireTime())
                .build();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_TYPE)) {
            return bearerToken.substring(BEARER_TYPE.length(),bearerToken.length());
        }
        return null;
    }

    public RefreshTokenInfo resolveRefreshToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(REFRESH_HEADER);
        Long expire = getRefreshExpiration(bearerToken);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_TYPE)) {
            return RefreshTokenInfo.builder()
                    .REFRESH_TOKEN(bearerToken.substring(BEARER_TYPE.length(),bearerToken.length()))
                    .refreshTokenExpirationTime(expire)
                    .build();
        }
        return null;
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            throw new IllegalArgumentException("다시 로그인 해주세요!");
        }
    }
    public Long getExpiration(String accessToken) {
        // accessToken 남은 유효시간
        Date expiration = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(accessToken).getBody().getExpiration();
        // 현재 시간
        Long now = new Date().getTime();
        return (expiration.getTime() - now);
    }
    public Long getRefreshExpiration(String refreshToken) {
        // accessToken 남은 유효시간
        Date expiration = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(refreshToken).getBody().getExpiration();
        return expiration.getTime();
    }

}
