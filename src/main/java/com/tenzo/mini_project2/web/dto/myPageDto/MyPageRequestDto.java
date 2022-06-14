package com.tenzo.mini_project2.web.dto.myPageDto;

import lombok.Getter;

@Getter
public class MyPageRequestDto {
    private Long postId;
    private String title;
    private String content;
    private String tags;
    private String position;
}
