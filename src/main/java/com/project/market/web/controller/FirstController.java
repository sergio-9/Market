package com.project.market.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/helloWorld")
    public String getHelloWorld() {
        return new String("Hello world");
    }
    

}
