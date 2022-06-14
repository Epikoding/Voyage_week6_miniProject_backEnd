package com.tenzo.mini_project2.web.dto.postDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostRequestDto {

    private String title;
    private String content;
    private String imgUrl;
    private String tags;
    private String position;

}