package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDeleteRequestDto;
import com.tenzo.mini_project2.web.dto.commentDto.CommentDto;
import com.tenzo.mini_project2.web.dto.postDto.PostRequestDto;
import com.tenzo.mini_project2.web.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PermitAll
    @GetMapping("/all")
    public ResponseEntity<?> postAll(){
        return new ResponseEntity<>(postService.getPostAll(), HttpStatus.OK) ;
    }

    @PermitAll
    @GetMapping("/allTags")
    public ResponseEntity<?> tagsAll(){
        return new ResponseEntity<>(postService.getAllTags(), HttpStatus.OK) ;
    }


    @PostMapping("/upload")
    public ResponseEntity<?> postMeme(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto postRequestDto){
        return postService.enrollMeme(userDetails, postRequestDto);
    }
    //댓글 조회
    @PermitAll
    @GetMapping("/getCommentsByPostId")
    public ResponseEntity<?>getCommentsByPostId(@RequestParam Long postId){
        return postService.getCommentsById(postId);
    }
    @PostMapping("/comments")
    public ResponseEntity<?> postComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentDto commentDto){
        return postService.postComment(userDetails, commentDto);
    }

    @PostMapping("/commentDelete")
    public ResponseEntity<?> commentDelete(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentDeleteRequestDto dto){
        return postService.commentDelete(userDetails, dto);
    }

}
