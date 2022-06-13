package com.tenzo.mini_project2.security.model;

import com.tenzo.mini_project2.security.dto.SignupRequestDto;
import lombok.*;

import javax.persistence.*;


@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Entity(name = "userInfo")
@Builder
public class User extends Timestamped {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "ROLE_USER";

    public User(SignupRequestDto dto) {
        this.nickname = dto.getNickname();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }
}