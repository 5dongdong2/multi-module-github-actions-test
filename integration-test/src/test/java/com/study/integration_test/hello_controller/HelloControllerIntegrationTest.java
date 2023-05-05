package com.study.integration_test.hello_controller;

import com.study.common.dto.ItemDto;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloControllerIntegrationTest {

    private final String URL = "http://localhost:8080";

    @Test
    void SAVE_GET() {
        String content = UUID.randomUUID().toString();
        //SAVE
        String savedItemResponseMessageBody = given()
                .contentType(ContentType.JSON)
                .body(ItemDto.builder()
                        .content(content)
                        .build())
                .post(URL + "/api/item")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .asString();

        Integer savedId = Integer.valueOf(savedItemResponseMessageBody);

        //GET
        given()
                .contentType(ContentType.JSON)
                .get(URL + "/api/item/" + savedId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(savedId))
                .body("content", equalTo(content));
    }

}
