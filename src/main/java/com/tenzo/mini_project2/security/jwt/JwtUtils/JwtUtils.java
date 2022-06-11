package com.tenzo.mini_project2.security.jwt.JwtUtils;

import com.tenzo.mini_project2.domain.respository.UserRepository;
import com.tenzo.mini_project2.security.dto.UserResponseDto;
import com.tenzo.mini_project2.security.jwt.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {


    private final Key key;


    public JwtUtils(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    // 1. 헤더 JWT 토큰 추출
    public String extractToken(HttpServletRequest request) {

        String token = request.getHeader(JwtSetting.AUTHORIZATION_HEADER.getSetting());
        if (!StringUtils.hasText(token) || !token.startsWith(JwtSetting.HEADER_PREFIX.getSetting())) {
            throw new IllegalArgumentException("유효한 토큰이 아닙니다.");
        }
        return token.substring(JwtSetting.HEADER_PREFIX.getSetting().length(), token.length());
    }

    public UserResponseDto.TokenInfo generateToken(UserDetailsImpl userDetails) {
        String token = null;

        long now = (new Date()).getTime();

        // access token
        Date accessTokenExpiresIn = new Date(now + JwtSetting.ExpireTime.ACCESS_TOKEN_EXPIRE_TIME.getExpireTime());
        String accessToken = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("userId", userDetails.getUser().getId())
                .claim("pw", userDetails.getPassword())
                .claim("login_id",userDetails.getUser().getLogin_id())
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        //refresh token
        Date refreshTokenExpiresIn = new Date(now + JwtSetting.ExpireTime.REFRESH_TOKEN_EXPIRE_TIME.getExpireTime());
        String refreshToken = Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return UserResponseDto.TokenInfo.builder()
                .grantType(JwtSetting.HEADER_PREFIX.getSetting())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .refreshTokenExpirationTime(JwtSetting.ExpireTime.REFRESH_TOKEN_EXPIRE_TIME.getExpireTime())
                .build();


    }

//    public Authentication getAuthentication(String accessToken){
//        Claims claims = parseClaims(accessToken);
//        if(claims.getSubject() ==null){
//            throw new RuntimeException("권한이 없는 사용자 입니다.");
//        }
////        User user = new User(claims.get(""))
////        UserDetails userDetails = new UserDetailsImpl()
//
//    }
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}
