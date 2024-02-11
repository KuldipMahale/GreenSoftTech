package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.entity.UserValidate;
import com.greensoft.springboot.entity.Users;

import java.util.List;


public interface UsersService {

    public UsersDto saveUser(UsersDto user);

    public UsersDto updateUser(UsersDto user, Integer userId);

    public List<UsersDto> getAllUsers();

    public UsersDto getUser(Integer userId);

    public String deleteUser(Integer userId);

    public Boolean findByUsername(UserValidate user);

    Users lodaUserByUserName(String userName);
}