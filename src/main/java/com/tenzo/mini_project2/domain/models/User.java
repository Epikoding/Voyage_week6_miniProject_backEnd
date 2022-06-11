package com.tenzo.mini_project2.domain.models;

import com.tenzo.mini_project2.security.dto.UserDto;
import com.tenzo.mini_project2.security.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "userInfo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String nickname;
    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    public User(UserRequestDto.SignUp dto) {
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.password = dto.getPassword();
        this.role = "ROLE_USER";
    }

}
