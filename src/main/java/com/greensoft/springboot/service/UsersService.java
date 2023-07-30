package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.entity.Users;

import java.util.List;

public interface UsersService {

    public UsersDto saveUser(UsersDto user);

    public UsersDto updateUser(UsersDto user,Long userId);

    public List<UsersDto> getAllUsers();

    public UsersDto getUser(Long userId);

    public String deleteUser(Long userId);

}
