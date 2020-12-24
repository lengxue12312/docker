package com.example.docker.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/docker")
    public String hello(){
        return "docker";
    }
}
