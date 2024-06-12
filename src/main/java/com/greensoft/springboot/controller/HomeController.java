package com.greensoft.springboot.controller;

import com.greensoft.springboot.entity.DummyUsers;
import com.greensoft.springboot.service.impl.DummyUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private DummyUserServices  services;

    @RequestMapping("/users")
    public List<DummyUsers> test() {
        this.logger.warn("This is working message");
        return this.services.getUsers();
    }

    @RequestMapping("/get-logged-in-user")
    public  String getLoggedInUser(Principal principal){
        return  principal.getName();
    }

}
