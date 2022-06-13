package com.tenzo.mini_project2.domain.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private String tags;

//    @OneToMany(mappedBy = "post")
//    @JoinColumn(nullable = true)
//    private List<Comment> commentList;

    @Column(nullable = false)
    private String position;
    // FIXME: 2022/06/11
    // enum 처리할 것
}
