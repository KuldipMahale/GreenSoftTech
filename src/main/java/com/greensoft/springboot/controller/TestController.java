package com.greensoft.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/test")
public class TestController {

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome to Test Controller", HttpStatus.OK);
    }
}
