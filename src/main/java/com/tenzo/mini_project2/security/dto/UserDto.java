package com.tenzo.mini_project2.security.dto;


import com.tenzo.mini_project2.domain.models.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String role;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}
