package com.tenzo.mini_project2.web.dto.myPageDto;

import lombok.Getter;

@Getter
public class MyPageRequestDto {
    private Long userId;
    private Long postId;
    private String title;
    private String contents;
    private String tag;
    private Enum position;

    public enum position {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }
}
