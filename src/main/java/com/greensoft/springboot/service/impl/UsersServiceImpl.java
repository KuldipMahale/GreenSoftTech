package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.Users;
import com.greensoft.springboot.repository.CustomersRepository;
import com.greensoft.springboot.repository.UsersRepo;
import com.greensoft.springboot.service.UsersService;
import com.greensoft.springboot.repository.UsersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepo repo;

    @Autowired
    private ModelMapper model;
    @Override
    public UsersDto saveUser(UsersDto user) {
        return this.model.map(this.model.map(user, Users.class),UsersDto.class) ;
    }

    @Override
    public UsersDto updateUser(UsersDto user, Long userId) {
        return null;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return null;
    }

    @Override
    public UsersDto getUser(Long userId) {
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        return null;
    }
}
