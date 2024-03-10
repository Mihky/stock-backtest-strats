package com.mihky.backtest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
    @GetMapping("/health_check")
    public String getPing() {
        return "Hi, I'm healthy..";
    }
}
