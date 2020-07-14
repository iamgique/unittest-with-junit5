package com.digitalacademy.unittestwithjunit5.controller;

import com.digitalacademy.unittestwithjunit5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/list")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping(path="/")
    public ResponseEntity<?> getSingleUser() {
        return ResponseEntity.ok(userService.getSingleUser());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
