package com.tenzo.mini_project2.security.service;

import com.tenzo.mini_project2.security.dto.UserDto;
import com.tenzo.mini_project2.security.dto.UserResponseDto;
import com.tenzo.mini_project2.security.jwt.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface JwtTokenProvider {
    //토큰 추출
    String extractToken(HttpServletRequest request);
    //토큰 생성
    UserResponseDto.TokenInfo generateToken(UserDetailsImpl userDetails);

    Authentication getAuthentication(String accessToken);

    UserDetails getUserDetails(String accessToken);

    UserDto parseClaims(String accessToken);

    Boolean validateToken(String token);

    Long getExpiration(String accessToken);
}
