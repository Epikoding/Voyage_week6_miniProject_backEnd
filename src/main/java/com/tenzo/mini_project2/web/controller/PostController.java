package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.domain.models.Comment;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/upload")
    public ResponseEntity<?> postMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto postRequestDto){
        return postService.enrollMeme(userDetails, postRequestDto);
    }

    @PostMapping("/comments")
    public ResponseEntity<?> postComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentDto commentDto){
        return postService.postComment(userDetails, commentDto);
    }

}
