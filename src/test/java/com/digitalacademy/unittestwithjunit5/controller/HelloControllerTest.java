package com.digitalacademy.unittestwithjunit5.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloControllerTest {

    @InjectMocks
    HelloController helloController;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        helloController = new HelloController();
        mvc = MockMvcBuilders.standaloneSetup(helloController)
                .build();
    }

    @DisplayName("Test get hello return Hello World")
    @Test
    void testGetHello() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();
    }

    @DisplayName("Test get hello by name return Hello Test")
    @Test
    void testGetHelloByName() throws Exception {
        String data = "Test";

        mvc.perform(get("/hello/" + data))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Test"))
                .andReturn();
    }

}
