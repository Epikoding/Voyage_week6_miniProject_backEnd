package com.tenzo.mini_project2.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenzo.mini_project2.security.dto.ErrorResponse;
import com.tenzo.mini_project2.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;
    private final RedisTemplate<String, Object> redisTemplate;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (IllegalArgumentException e) {
            forceLogout(request,response);

        }
    }

    public void forceLogout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            String token = jwtTokenProvider.resolveToken(request);
            if(token == null){
                throw new IllegalStateException("다시 로그인 해주세요");
            }
            String email = jwtTokenProvider.getUserPk(token);
            if (redisTemplate.opsForValue().get("RT:" + email) != null) {
                // Refresh Token 삭제
                redisTemplate.delete("RT:" + email);
            }
            //4. logout accessToken manage
            Long expiration = jwtTokenProvider.getExpiration(token);
            redisTemplate.opsForValue()
                    .set(token, "logout", expiration, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, response, e);
        }

    }

    public void setErrorMessage(HttpStatus status, HttpServletResponse response, Throwable e) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status.value());
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
