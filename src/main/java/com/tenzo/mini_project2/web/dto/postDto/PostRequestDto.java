package com.tenzo.mini_project2.web.dto.postDto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;
    private String imgUrl;
    private String tags;
    private String position;

}