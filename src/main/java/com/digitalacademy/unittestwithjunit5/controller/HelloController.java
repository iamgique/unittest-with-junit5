package com.digitalacademy.unittestwithjunit5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HelloController {
    @GetMapping(path="/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(path="/hello/{name}")
    public String name(@PathVariable String name) {
        return "Hello " + name;
    }
}
