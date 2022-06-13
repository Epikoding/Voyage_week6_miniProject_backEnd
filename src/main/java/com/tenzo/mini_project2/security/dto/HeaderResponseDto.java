package com.tenzo.mini_project2.security.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HeaderResponseDto {
    private String ACCESS_TOKEN;
    private String REFRESH_TOKEN;
    private String grantType;
    private Long refreshTokenExpirationTime;
}