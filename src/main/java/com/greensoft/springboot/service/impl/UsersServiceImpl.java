package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.entity.Users;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CustomersRepository;
import com.greensoft.springboot.repository.UsersRepo;
import com.greensoft.springboot.service.UsersService;
import com.greensoft.springboot.repository.UsersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Users oldUser = repo.findById(userId).get();
        if (oldUser != null)
            repo.deleteById(userId);
        else
            throw new NotFoundException("User with id : '" + userId + "' not Exist");

      //  return  "User with id : '" + userId + "' deleted Successfully";
        return null;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return null;
    }

    @Override
    public UsersDto getUser(Long userId) {
        return this.model.map(repo.findById(userId), UsersDto.class);
    }

    @Override
    public String deleteUser(Long userId) {

        Users user = repo.findById(userId).get();
        if (user != null)
            repo.deleteById(userId);
        else
            throw new NotFoundException("User with id : '" + userId + "' not Exist");

        return  "User with id : '" + userId + "' deleted Successfully";
    }
}
