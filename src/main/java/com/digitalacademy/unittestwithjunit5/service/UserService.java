package com.digitalacademy.unittestwithjunit5.service;

import com.digitalacademy.unittestwithjunit5.example.UserDataExample;
import com.digitalacademy.unittestwithjunit5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDataExample userDataExample;

    @Autowired
    public UserService(UserDataExample userDataExample) {
        this.userDataExample = userDataExample;
    }

    public List<User> getUserList() {
        System.out.println("Get all user");
        return userDataExample.getUserList();
    }

    public User getSingleUser() {
        System.out.println("Get single user");
        return userDataExample.getSingleUser();
    }

    public User getUserById(Integer id) {
        System.out.println("Get user by id: " + id);
        User user = userDataExample.getUserList()
                .stream()
                .filter(u -> u.getId() == id)
                .findAny()
                .orElse(new User());
        return user;
    }
}
