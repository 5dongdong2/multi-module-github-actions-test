package com.study.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
@Slf4j
public class HealthCheckController {

    @GetMapping("/api/health")
    public void healthCheck() {
        log.info("health check at {}", LocalDateTime.now());
    }
}
