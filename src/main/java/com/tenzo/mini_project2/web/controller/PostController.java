package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.domain.models.Comment;

import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.dto.postDto.postResponseDto;
import com.tenzo.mini_project2.web.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    // FIXME: 2022/06/13 return을 postResponseDto로 해야함. 2. 권한이 없습니다 등 같은 예외처리 필요.
    @PostMapping("/posts/upload")
    public postResponseDto postMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto postRequestDto){
        return postService.enrollMeme(userDetails, postRequestDto);
    }

    @PostMapping("/comments")
    public Comment postComment(@RequestBody CommentDto commentDto){
        return postService.postComment(commentDto);
    }

}
