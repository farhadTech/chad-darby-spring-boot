package com.example.thymeleafdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloWorldController {
    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form




}
