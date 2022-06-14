package com.tenzo.mini_project2.domain.models;

import com.tenzo.mini_project2.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private String tags;

    @OneToMany
    @JoinColumn(name = "comments")
    private List<Comment> commentList;

    @Column(nullable = false)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY) //LAZY를 이용할 때는 .get을 할때만 조회가 가능. fetch가 없다면 한 번에 다 가져옴.
    @JoinColumn(name = "user_id")
    private User user;
}
