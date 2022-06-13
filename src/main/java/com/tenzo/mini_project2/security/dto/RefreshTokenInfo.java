package com.tenzo.mini_project2.security.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshTokenInfo {
    private String REFRESH_TOKEN;
    private Long refreshTokenExpirationTime;
}
