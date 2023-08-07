package com.spring.course_1.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String mainPage()
    {
        return "hello this is main page";
    }

}
