package com.minorm.eduproject.http.controller;

import com.minorm.eduproject.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "Hello!";
    }

    @GetMapping("/registration")
    public String registration() {
        return userService.addUser();
    }
}
