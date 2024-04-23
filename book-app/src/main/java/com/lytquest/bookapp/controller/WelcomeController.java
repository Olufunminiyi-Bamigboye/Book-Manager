package com.lytquest.bookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class WelcomeController {

    @GetMapping("welcome")
    public String welcomeUser(){

        return "Welcome to my Book Application";
    }
}
