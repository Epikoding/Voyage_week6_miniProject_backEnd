package com.tenzo.mini_project2.domain.models;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;
}
