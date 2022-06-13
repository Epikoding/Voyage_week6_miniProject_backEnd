package com.tenzo.mini_project2.web.dto.myPageDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyPageResponseDto {
    private Long userId;
    private Long postId;
    private String title;
    private String contents;
    private String imgUrl;
    private String position;

}
