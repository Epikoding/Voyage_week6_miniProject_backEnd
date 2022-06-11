package com.tenzo.mini_project2.security.jwt.JwtUtils;

public enum JwtSetting {

    // jwt 토큰 키워드
    AUTHORIZATION_HEADER("Authorization"),
    HEADER_PREFIX("Bearer"),
    AUTHORITIES_KEY("auth");


    private final String setting;

    JwtSetting( String setting) {
        this.setting = setting;
    }
    String getSetting(){
        return setting;
    }

    // 유효시간
    enum ExpireTime{
        ACCESS_TOKEN_EXPIRE_TIME( 30 * 60 * 1000L),
        REFRESH_TOKEN_EXPIRE_TIME(7 * 24 * 60 * 60 * 1000L);

        private final Long ExpireTime;
        ExpireTime(Long expireTime){
            this.ExpireTime = expireTime;
        }
        Long getExpireTime(){
            return this.ExpireTime;
        }
    }
}
