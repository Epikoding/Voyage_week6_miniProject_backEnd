package com.tenzo.mini_project2.web.dto.postDto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostRequestDto {

    private String title;
    private String content;
    private String imgUrl;
    private List<String> tagList;
    private String position;

}