package com.dev.example.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPing {

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
}
