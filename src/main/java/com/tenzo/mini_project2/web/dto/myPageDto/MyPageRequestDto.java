package com.tenzo.mini_project2.web.dto.myPageDto;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Getter
public class MyPageRequestDto {

    private Long id;
    private String title;
    private String up_layer_value;
    private String down_layer_value;
    private String up_txt;
    private String down_txt;
    private List<String> tagList;

}
