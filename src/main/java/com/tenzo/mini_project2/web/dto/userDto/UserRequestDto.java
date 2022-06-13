package com.tenzo.mini_project2.web.dto.userDto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private Long id;
    private String email;
    private String password;
    private String nickName;
}
