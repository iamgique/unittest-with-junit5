package com.digitalacademy.unittestwithjunit5.example;

import com.digitalacademy.unittestwithjunit5.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataExample {
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setFirstName("Somsak");
        user.setLastName("Saijai");
        user.setAge(30);
        user.setEmail("somsak.saijai@s.co.th");
        users.add(user);

        user = new User();
        user.setId(2);
        user.setFirstName("Oratai");
        user.setLastName("Jaidee");
        user.setAge(20);
        user.setEmail("oratai.jaidee@s.co.th");
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

    public User getSingleUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Somsak");
        user.setLastName("Saijai");
        user.setAge(30);
        user.setEmail("somsak.saijai@s.co.th");
        return user;
    }
}
