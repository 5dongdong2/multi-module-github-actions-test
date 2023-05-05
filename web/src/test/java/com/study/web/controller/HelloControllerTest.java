package com.study.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.dto.ItemDto;
import com.study.web.service.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    HelloService helloService;
    @Autowired
    ObjectMapper objectMapper;
    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void testGet() throws Exception {
        long id = 1L;
        String content = "content";
        LocalDateTime createdTime = LocalDateTime.now();
        ItemDto responseMessageBody = ItemDto.builder()
                .id(id)
                .content("content")
                .createdAt(createdTime)
                .build();

        when(helloService.getItem(id)).thenReturn(responseMessageBody);

        this.mockMvc.perform(get("/api/get/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        objectMapper.writeValueAsString(responseMessageBody),
                        false));

        verify(helloService, times(1)).getItem(longArgumentCaptor.capture());

        assertThat(longArgumentCaptor.getValue()).isEqualTo(id);
    }
}