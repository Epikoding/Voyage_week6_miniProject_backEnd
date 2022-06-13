package com.tenzo.mini_project2.security.filter;

import com.tenzo.mini_project2.security.jwt.JwtUtils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * JWT token 검증 및 spring security context 에 보관
 *
 *
 * */

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtUtils jwtUtils;

    public JwtAuthenticationFilter(RequestMatcher requestMatcher, JwtUtils utils) {
        super(requestMatcher);
        this.jwtUtils = utils;
    }


    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException, IOException, ServletException
    {
        try {
            String tokenPayload = jwtUtils.extractToken(request);
        }catch (IllegalArgumentException e){

        }


        return null;
    }

}
