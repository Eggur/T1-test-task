package com.eggur.task.controller;

import com.eggur.task.service.CharacterFrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterFrequencyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CharacterFrequencyService characterFrequencyService;

    @Test
    void getSymbolsFrequency() throws Exception {
        String validInput = "aaabccccc";
        mockMvc.perform(get("/task/count")
                        .param("str", validInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.a").value(3))
                .andExpect(jsonPath("$.b").value(1))
                .andExpect(jsonPath("$.c").value(5))
                .andExpect(content().string("{\"c\":5,\"a\":3,\"b\":1}"));
    }

    @Test
    public void testMissingParameter() throws Exception {
        mockMvc.perform(get("/task/count"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Required parameter 'str' is not present."));
    }
}