package com.tenzo.mini_project2.security.jwt;

public enum JwtSetting {

    // jwt 토큰 키워드
    AUTHORIZATION_HEADER("Authorization"),
    HEADER_PREFIX("Bearer"),
    AUTHORITIES_KEY("auth");


    private final String setting;

    JwtSetting( String setting) {
        this.setting = setting;
    }
    public String getSetting(){
        return setting;
    }

    // 유효시간
    public enum ExpireTime{
        ACCESS_TOKEN_EXPIRE_TIME( 40 * 60 * 1000L),// 30분
        REFRESH_TOKEN_EXPIRE_TIME(7 * 24 * 60 * 60 * 1000L);//7일

        private final Long ExpireTime;
        ExpireTime(Long expireTime){
            this.ExpireTime = expireTime;
        }
        public Long getExpireTime(){
            return this.ExpireTime;
        }
    }
}
