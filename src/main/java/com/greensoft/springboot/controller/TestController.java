package com.greensoft.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/test")
public class TestController {

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome to Test Controller", HttpStatus.OK);
    }


    @GetMapping("/who")
    public ResponseEntity<String> getLoggedUserName(Principal principal){
        String loggedUserName = principal.getName();
        return new ResponseEntity<>(loggedUserName,HttpStatus.OK);
    }
}
