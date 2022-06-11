package com.tenzo.mini_project2.security.controller;

import com.tenzo.mini_project2.security.dto.UserRequestDto;
import com.tenzo.mini_project2.security.service.JwtTokenProvider;
import com.tenzo.mini_project2.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated UserRequestDto.Login login) {
        return userService.login(login);
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Validated UserRequestDto.Logout logout) {
        return userService.logout(logout);
    }



}
