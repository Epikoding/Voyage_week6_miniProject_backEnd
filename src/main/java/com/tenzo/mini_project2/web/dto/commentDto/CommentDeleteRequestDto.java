package com.tenzo.mini_project2.web.dto.commentDto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDeleteRequestDto {
    Long postId;
    Long commentId;

    public CommentDeleteRequestDto(Long postId, Long commentId) {
        this.postId = postId;
        this.commentId = commentId;
    }
}
