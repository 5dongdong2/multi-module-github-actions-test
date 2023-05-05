package com.study.web.controller;

import com.study.common.dto.ItemDto;
import com.study.web.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/api/get/{id}")
    public ItemDto getItem(@PathVariable Long id) {
        return helloService.getItem(id);
    }

}
