package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.UserValidate;
import com.greensoft.springboot.entity.Users;
import com.greensoft.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping( "/user")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> saveUser(@Valid @RequestBody UsersDto user) {
        UsersDto userDto = service.saveUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> updateUser( @Valid @RequestBody UsersDto userDto ,@PathVariable Long userId) {
        UsersDto usersDto = service.updateUser(userDto , userId);
        return new ResponseEntity<>(usersDto, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/user-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersDto>> getAllCustomers() {
        List<UsersDto> usersDtos = service.getAllUsers();
        return new ResponseEntity<>(usersDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> getUserById(@PathVariable Long userId) {
        UsersDto usersDto = service.getUser(userId);
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long userId) {
        String message = service.deleteUser(userId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/login-validate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> validateUser(@Valid @RequestBody UserValidate user) {
//        Users userDto = service.findByUsername(userDto);

        System.out.println("******************************************************");
        System.out.println(service.findByUsername(user));
        System.out.println("******************************************************");
        return new ResponseEntity<>(service.findByUsername(user), HttpStatus.OK);
    }
}
