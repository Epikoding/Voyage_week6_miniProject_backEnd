package com.tenzo.mini_project2.web.dto.postDto;

import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.Tags;
import lombok.Data;

import java.util.List;

@Data
public class PostResponseDto {

    private Long id;
    private String title;
    private String imgUrl;
    private String up_layer_value;
    private String down_layer_value;
    private String up_txt;
    private String down_txt;
    private List<Tags> tagList;
    private String email;
    private int commentCnt;
    //private String nickname;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.imgUrl = post.getImgUrl();
        this.up_layer_value = post.getUp_layer_value();
        this.down_layer_value = post.getDown_layer_value();
        this.up_txt = post.getUp_txt();
        this.down_txt = post.getDown_txt();
        this.tagList = post.getTagList();
        this.email = post.getUser().getEmail();
        this.commentCnt = post.getCommentList().size();
    }
}
