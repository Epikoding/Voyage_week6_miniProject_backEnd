package com.tenzo.mini_project2.domain.models;

import com.tenzo.mini_project2.security.model.Timestamped;
import com.tenzo.mini_project2.security.model.User;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imgUrl;

    @Column
    private String up_layer_value;

    @Column
    private String down_layer_value;

    @Column
    private String up_txt;

    @Column
    private String down_txt;

    @OneToMany
    @JoinColumn(name = "tags")
    private List<Tags> tagList;

    //말풍선 안에 문구

    @OneToMany
    @JoinColumn(name = "comments")
    private List<Comment> commentList;


    @ManyToOne(fetch = FetchType.LAZY) //LAZY를 이용할 때는 .get을 할때만 조회가 가능. fetch가 없다면 한 번에 다 가져옴.
    @JoinColumn(name = "user_id")
    private User user;

    public void update(MyPageRequestDto dto, List<Tags>tags) {

        this.title = dto.getTitle();
        this.up_layer_value = dto.getUp_layer_value();
        this.down_layer_value = dto.getDown_layer_value();
        this.up_txt = dto.getUp_txt();
        this.down_txt = dto.getDown_txt(); ;
        this.tagList = tags;

    }


}
