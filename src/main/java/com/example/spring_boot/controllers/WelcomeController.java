package com.example.spring_boot.controllers;


import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private UserService userService;

    public WelcomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String welcome() {
        return "welcome/welcome";
    }
}
