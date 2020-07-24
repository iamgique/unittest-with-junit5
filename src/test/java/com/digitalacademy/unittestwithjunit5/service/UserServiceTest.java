package com.digitalacademy.unittestwithjunit5.service;

import com.digitalacademy.unittestwithjunit5.example.UserDataExample;
import com.digitalacademy.unittestwithjunit5.model.User;
import com.digitalacademy.unittestwithjunit5.support.SupportUserDataTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    UserDataExample userDataExample;

    @InjectMocks
    UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userDataExample);
    }

    @DisplayName("Test get user list should return list")
    @Test
    void testGetUserList() {

        when(userDataExample.getUserList())
                .thenReturn(SupportUserDataTest.getUserList());

        List<User> resp = userService.getUserList();

        assertEquals(1, resp.get(0).getId().intValue());
        assertEquals("Chayapol", resp.get(0).getFirstName());
        assertEquals("Saijai", resp.get(0).getLastName());
        assertEquals(30, resp.get(0).getAge().intValue());
        assertEquals("Chayapol.saijai@s.co.th", resp.get(0).getEmail());

        assertEquals(2, resp.get(1).getId().intValue());
        assertEquals("Kittipoom", resp.get(1).getFirstName());
        assertEquals("Jaidee", resp.get(1).getLastName());
        assertEquals(20, resp.get(1).getAge().intValue());
        assertEquals("Kittipoom.jaidee@s.co.th", resp.get(1).getEmail());

        assertEquals(3, resp.get(2).getId().intValue());
        assertEquals("Thammasak", resp.get(2).getFirstName());
        assertEquals("Makmee", resp.get(2).getLastName());
        assertEquals(20, resp.get(2).getAge().intValue());
        assertEquals("thammasak.makmee@s.co.th", resp.get(2).getEmail());

        verify(userDataExample, times(1)).getUserList();
    }

    @DisplayName("Test get single user")
    @Test
    void testGetSingleUser() {
        when(userDataExample.getSingleUser())
                .thenReturn(SupportUserDataTest.getSingleUser());

        User resp = userService.getSingleUser();

        assertEquals(1, resp.getId().intValue());
        assertEquals("Somsak", resp.getFirstName());
        assertEquals("Saijai", resp.getLastName());
        assertEquals(30, resp.getAge().intValue());
        assertEquals("somsak.saijai@s.co.th", resp.getEmail());

        verify(userDataExample, times(1)).getSingleUser();
    }

    @DisplayName("Test get user by id 2")
    @Test
    void testGetUsetById2() {
        Integer id = 2;
        when(userDataExample.getUserList())
                .thenReturn(SupportUserDataTest.getUserList());

        User resp = userService.getUserById(id);
        assertEquals(2, resp.getId().intValue());
        assertEquals("Kittipoom", resp.getFirstName());
        assertEquals("Jaidee", resp.getLastName());
        assertEquals(20, resp.getAge().intValue());
        assertEquals("Kittipoom.jaidee@s.co.th", resp.getEmail());

        verify(userDataExample, times(1)).getUserList();
    }

}
