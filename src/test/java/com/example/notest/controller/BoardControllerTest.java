package com.example.notest.controller;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.notest.dto.BoardRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@DataMongoTest
@AutoConfigureMockMvc
@SpringBootTest
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void 트랜잭션_Rollback작동될가() throws Exception{
        BoardRequestDto boardRequestDto = new BoardRequestDto("테스트제목이지롱1", "테스트내용이지롱1");
        mockMvc.perform(post("/boards").content(objectMapper.writeValueAsString(boardRequestDto)).contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}