package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageResponseDto;
import com.tenzo.mini_project2.web.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyPageController {
    private final MyPageService myPageService;

    @Autowired
    public MyPageController(MyPageService myPageService, PostRepository postRepository) {
        this.myPageService = myPageService;
    }

    @GetMapping("/selectMyPage/{id}")
    public List<MyPageResponseDto> showMyPage(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return myPageService.showMyPage(id, userDetails);
    }

    @PutMapping("/updateMyPage")
    public ResponseEntity<?> editMyPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody MyPageRequestDto myPageRequestDto) {
        return myPageService.update(userDetails, myPageRequestDto);
    }

    @DeleteMapping("/deleteMyPage/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return myPageService.delete(id, userDetails);
    }
}
