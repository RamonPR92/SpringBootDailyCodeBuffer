package com.ramon.apirestdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //it is a reference to property in application.properties file
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String hello(){
        return welcomeMessage;
    }
}
