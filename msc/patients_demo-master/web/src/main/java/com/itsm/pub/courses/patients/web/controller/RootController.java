package com.itsm.pub.courses.patients.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

    @RequestMapping("/")
    public String root() {
        return "Hello!";
    }
}
