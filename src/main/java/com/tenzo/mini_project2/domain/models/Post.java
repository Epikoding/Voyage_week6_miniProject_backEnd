package com.tenzo.mini_project2.domain.models;

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

    @OneToMany(mappedBy = "post")
    @JoinColumn(name = "comments", nullable = false)
    private List<Comment> commentList;

    @Column(nullable = false)
    private Enum position;

    public enum position {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
