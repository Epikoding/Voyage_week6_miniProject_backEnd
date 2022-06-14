package com.tenzo.mini_project2.web.dto.myPageDto;

import lombok.Getter;

import java.util.List;

@Getter
public class MyPageRequestDto {
    private Long postId;
    private String title;
    private String content;
    private List<String> tags;
    private String position;
}
