package com.example.spring_boot.controllers;

import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String show(Authentication authentication, Model model) {
        String name = authentication.getName();
        model.addAttribute("user", userService.getUserByName(name));
        return "user/showUser";
    }
}
