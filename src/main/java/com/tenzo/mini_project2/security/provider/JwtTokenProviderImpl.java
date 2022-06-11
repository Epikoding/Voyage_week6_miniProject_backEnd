package com.tenzo.mini_project2.security.provider;

import com.tenzo.mini_project2.security.dto.UserDto;
import com.tenzo.mini_project2.security.dto.UserResponseDto;
import com.tenzo.mini_project2.security.jwt.UserDetailsImpl;
import com.tenzo.mini_project2.security.service.JwtTokenProvider;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProviderImpl implements JwtTokenProvider {

    private final Key key;


    public JwtTokenProviderImpl(@Value("${jwt.secret}") String secretKey) {
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

        long now = (new Date()).getTime();

        // access token
        Date accessTokenExpiresIn = new Date(now + JwtSetting.ExpireTime.ACCESS_TOKEN_EXPIRE_TIME.getExpireTime());
        String accessToken = Jwts.builder()
                //기존 username -> nickname
                .setSubject(userDetails.getUsername())
                .claim("userId", userDetails.getUser().getId())
                .claim("pw", userDetails.getPassword())
                .claim("role", userDetails.getUser().getRole())
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

    public Authentication getAuthentication(String accessToken) {
        UserDetails userDetails = new UserDetailsImpl(parseClaims(accessToken));
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());

    }

    public UserDetails getUserDetails(String accessToken) {
        return new UserDetailsImpl(parseClaims(accessToken));
    }

    public UserDto parseClaims(String accessToken) {

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        if (claims.getSubject() == null) {
            throw new RuntimeException("권한이 없는 사용자 입니다.");
        }
        return UserDto.builder()
                .id((Long) claims.get("userId"))
                .password(String.valueOf(claims.get("pw")))
                .email(String.valueOf(claims.getSubject()))
                .role(String.valueOf(claims.get("role")))
                .build();
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Long getExpiration(String accessToken) {
        // accessToken 남은 유효시간
        Date expiration = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody().getExpiration();
        // 현재 시간
        long now = new Date().getTime();
        return (expiration.getTime() - now);
    }

}
