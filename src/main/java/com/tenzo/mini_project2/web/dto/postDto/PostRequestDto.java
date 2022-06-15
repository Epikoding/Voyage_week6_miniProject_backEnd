package com.tenzo.mini_project2.web.dto.postDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class PostRequestDto {

    private String title;
    private String imgUrl;
    private String up_layer_value;
    private String down_layer_value;
    private String up_txt;
    private String down_txt;
    private List<String> tagList;

}