package com.study.web.controller;

import com.study.common.dto.ItemDto;
import com.study.web.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/api/item/{id}")
    public ItemDto getItem(@PathVariable Long id) {
        return helloService.getItem(id);
    }

    @PostMapping(value = "/api/item")
    public Long saveItem(@RequestBody ItemDto itemDto) {
        return helloService.saveItem(itemDto);
    }

}
