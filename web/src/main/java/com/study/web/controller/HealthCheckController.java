package com.study.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class HealthCheckController {

    @GetMapping("/api/health")
    public Boolean healthCheck() {
        log.info("health check at {}", LocalDateTime.now());
        return true;
    }
}
