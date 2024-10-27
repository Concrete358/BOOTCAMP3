package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SimpleController {

    @Value("${DEVOPS}")
    private String devopsVariable;

    @GetMapping("/privet")
    public String privet() {
        return "PRIVET!";
    }

    @GetMapping("/zdarova")
    public String zdarova() {
        return "ZDAROVA!";
    }

    @GetMapping("czesc")
    public String czesc() {
        return "CZESC!";
    }

    @GetMapping("creator")
    public String creator() {
        return devopsVariable;
    }
}
