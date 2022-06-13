package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.domain.respository.PostRepository;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageRequestDto;
import com.tenzo.mini_project2.web.dto.myPageDto.MyPageResponseDto;
import com.tenzo.mini_project2.web.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyPageController {
    private final MyPageService myPageService;

    @Autowired
    public MyPageController(MyPageService myPageService, PostRepository postRepository) {
        this.myPageService = myPageService;
    }

    @GetMapping("/post/{id}")
    public List<MyPageResponseDto> showMyPage(@PathVariable Long id) {
        return myPageService.showMyPage(id);
    }

    @PutMapping("/post/{id}")
    public Long editMyPost(@PathVariable Long id, @RequestBody MyPageRequestDto myPageRequestDto) {
        return myPageService.update(id, myPageRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody MyPageRequestDto myPageRequestDto) {
        return myPageService.delete(id, myPageRequestDto);
    }
}
