package com.tenzo.mini_project2.security.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtPrePreprocessingToken extends UsernamePasswordAuthenticationToken {

    public JwtPrePreprocessingToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtPrePreprocessingToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
