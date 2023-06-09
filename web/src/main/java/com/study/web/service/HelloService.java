package com.study.web.service;

import com.study.common.dto.ItemDto;
import com.study.web.domain.Item;
import com.study.web.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    @Transactional(readOnly = true)
    public ItemDto getItem(Long id) {
        Item item = helloRepository.getReferenceById(id);
        return ItemDto.builder()
                .id(item.getId())
                .content(item.getContent())
                .createdAt(item.getCreatedAt())
                .build();
    }

    @Transactional
    public Long saveItem(ItemDto itemDto) {
        Item savedItem = helloRepository.save(new Item(null, itemDto.getContent(), null));
        return savedItem.getId();
    }
}
