package com.digitalacademy.unittestwithjunit5.support;

import com.digitalacademy.unittestwithjunit5.model.User;

import java.util.ArrayList;
import java.util.List;

public class SupportUserDataTest {
    public static List<User> getUserList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setFirstName("Chayapol");
        user.setLastName("Saijai");
        user.setAge(30);
        user.setEmail("Chayapol.saijai@s.co.th");
        users.add(user);

        user = new User();
        user.setId(2);
        user.setFirstName("Kittipoom");
        user.setLastName("Jaidee");
        user.setAge(20);
        user.setEmail("Kittipoom.jaidee@s.co.th");
        users.add(user);

        user = new User();
        user.setId(3);
        user.setFirstName("Thammasak");
        user.setLastName("Makmee");
        user.setAge(20);
        user.setEmail("thammasak.makmee@s.co.th");
        users.add(user);

        return users;
    }

    public static User getSingleUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Somsak");
        user.setLastName("Saijai");
        user.setAge(30);
        user.setEmail("somsak.saijai@s.co.th");
        return user;
    }
}
