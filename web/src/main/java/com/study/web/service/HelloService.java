package com.study.web.service;

import com.study.common.dto.ItemDto;
import com.study.web.domain.Item;
import com.study.web.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;
    public ItemDto getItem(Long id) {
        Item item = helloRepository.getReferenceById(id);
        return ItemDto.builder()
                .id(item.getId())
                .content(item.getContent())
                .createdAt(item.getCreatedAt())
                .build();
    }

}
