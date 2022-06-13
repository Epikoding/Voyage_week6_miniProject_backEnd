package com.tenzo.mini_project2.web.controller;

import com.tenzo.mini_project2.web.dto.userDto.UserRequestDto;
import com.tenzo.mini_project2.web.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/signup")
    public void signUp(@RequestBody UserRequestDto userRequestDto){
        userService.enrollUser(userRequestDto);
    }

    @PostMapping("/api/login")
    public void longIn(@RequestBody UserRequestDto userRequestDto){
        userService.logInUser(userRequestDto);
    }
}
