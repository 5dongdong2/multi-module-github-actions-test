package com.study.web.service

import com.study.common.dto.ItemDto
import com.study.web.domain.Item
import com.study.web.repository.HelloRepository
import spock.lang.Specification

import java.time.LocalDateTime

class HelloServiceTest extends Specification {

    def helloRepository = Mock(HelloRepository.class)
    def target = new HelloService(helloRepository)

    def "testGet"() {
        given:
        def id = ID
        def content = CONTENT
        def createdTime = CREATED_TIME
        Item item = new Item(id, content, createdTime)

        when:
        def result = target.getItem(id)

        then:
        1 * helloRepository.getReferenceById(id) >> item
        verifyAll {
            result.getId() == id
            result.getContent() == content
            result.getCreatedAt() == createdTime
        }

        where:
        ORDER | ID | CONTENT   | CREATED_TIME
        1     | 1L | "content" | LocalDateTime.now()
        2     | 1L | null      | LocalDateTime.now()
        3     | 1L | "content" | null
    }

    def "testSave"() {
        given:
        def content = "content"
        def itemDto = ItemDto.builder()
                .content(content)
                .build()
        def savedItem = new Item(1L, content, LocalDateTime.now())

        when:
        def result = target.saveItem(itemDto)

        then:
        1 * helloRepository.save(_ as Item) >> savedItem
        result == 1L
    }
}
