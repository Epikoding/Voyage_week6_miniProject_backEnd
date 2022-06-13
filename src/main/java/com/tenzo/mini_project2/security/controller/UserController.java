package com.tenzo.mini_project2.security.controller;


import com.tenzo.mini_project2.security.UserDetailsImpl;
import com.tenzo.mini_project2.security.dto.LoginRequestDto;
import com.tenzo.mini_project2.security.dto.SignupRequestDto;
import com.tenzo.mini_project2.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 회원 로그인
    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        return userService.logout(request);
    }

    // 회원 가입 요청 처리
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @PostMapping("/reissue")
    public void reissue(
        @AuthenticationPrincipal UserDetailsImpl userDetails,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        userService.reIssuance(userDetails, request, response);
    }


}