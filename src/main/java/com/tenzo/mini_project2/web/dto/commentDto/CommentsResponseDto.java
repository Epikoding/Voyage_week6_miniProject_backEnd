package com.tenzo.mini_project2.web.dto.commentDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import com.tenzo.mini_project2.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentsResponseDto {
    private Long id;
    private String nickname;
    private String content;
    private String createdAt;

    @QueryProjection
    public CommentsResponseDto(
            Long id,
            User user,
            String content,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.nickname = user.getNickname();
        this.content = content;
        this.createdAt = createdAt.toString();
    }
}
