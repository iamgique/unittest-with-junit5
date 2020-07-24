package com.digitalacademy.unittestwithjunit5.controller;


import com.digitalacademy.unittestwithjunit5.service.UserService;
import com.digitalacademy.unittestwithjunit5.support.SupportUserDataTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
        mvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @DisplayName("Test get user list")
    @Test
    void testGetUserList() throws Exception {

        when(userService.getUserList())
                .thenReturn(SupportUserDataTest.getUserList());

        MvcResult mvcResult = mvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        JSONArray jsonArray = new JSONArray(mvcResult.getResponse().getContentAsString());
        assertEquals("1", jsonArray.getJSONObject(0).get("id").toString());
        assertEquals("Chayapol", jsonArray.getJSONObject(0).get("firstName"));
        assertEquals("Saijai", jsonArray.getJSONObject(0).get("lastName"));
        assertEquals(30, jsonArray.getJSONObject(0).get("age"));
        assertEquals("Chayapol.saijai@s.co.th", jsonArray.getJSONObject(0).get("email"));

        assertEquals("2", jsonArray.getJSONObject(1).get("id").toString());
        assertEquals("Kittipoom", jsonArray.getJSONObject(1).get("firstName"));
        assertEquals("Jaidee", jsonArray.getJSONObject(1).get("lastName"));
        assertEquals(20, jsonArray.getJSONObject(1).get("age"));
        assertEquals("Kittipoom.jaidee@s.co.th", jsonArray.getJSONObject(1).get("email"));

        assertEquals("3", jsonArray.getJSONObject(2).get("id").toString());
        assertEquals("Thammasak", jsonArray.getJSONObject(2).get("firstName"));
        assertEquals("Makmee", jsonArray.getJSONObject(2).get("lastName"));
        assertEquals(20, jsonArray.getJSONObject(2).get("age"));
        assertEquals("thammasak.makmee@s.co.th", jsonArray.getJSONObject(2).get("email"));
    }

    @DisplayName("Test get single user")
    @Test
    void testGetSingleUser() throws Exception {

        when(userService.getSingleUser()).thenReturn(SupportUserDataTest.getSingleUser());

        MvcResult mvcResult = mvc.perform(get("/user/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        JSONObject jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());
        assertEquals("1", jsonObject.get("id").toString());
        assertEquals("Somsak", jsonObject.get("firstName"));
        assertEquals("Saijai", jsonObject.get("lastName"));
        assertEquals(30, jsonObject.get("age"));
        assertEquals("somsak.saijai@s.co.th", jsonObject.get("email"));
    }

    @DisplayName("Test get user by id 3")
    @Test
    void testGetUserById3() throws Exception {
        Integer id = 3;

        when(userService.getUserById(id))
                .thenReturn(SupportUserDataTest.getUserList().get(2));

        MvcResult mvcResult = mvc.perform(get("/user/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        JSONObject jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());
        assertEquals("3", jsonObject.get("id").toString());
        assertEquals("Thammasak", jsonObject.get("firstName"));
        assertEquals("Makmee", jsonObject.get("lastName"));
        assertEquals(20, jsonObject.get("age"));
        assertEquals("thammasak.makmee@s.co.th", jsonObject.get("email"));
    }
}
