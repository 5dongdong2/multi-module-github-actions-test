package com.study.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class ItemDto {

    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
}
