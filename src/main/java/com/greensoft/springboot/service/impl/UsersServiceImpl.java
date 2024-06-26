package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.service.UsersService;

public class UsersServiceImpl {}
/*
import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.dto.UsersDto;
import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.entity.UserValidate;
import com.greensoft.springboot.entity.Users;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.UsersRepo;
import com.greensoft.springboot.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepo repo;

    @Autowired
    private ModelMapper model;

    @Autowired
    private PasswordEncoder passwordEncoder;;
    @Override
    public UsersDto saveUser(UsersDto userDto) {
        userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        return   model.map(repo.save(this.model.map(userDto, Users.class)), UsersDto.class);
    }

    @Override
    public UsersDto updateUser(UsersDto user, Integer userId) {
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
        if (repo.findAll().isEmpty())
            throw new NotFoundException("Users Not Available");
         return  repo.findAll().stream().map( users -> model.map( users , UsersDto.class)).collect(Collectors.toList());
    }
    @Override
    public UsersDto getUser(Integer userId) {
        return this.model.map(repo.findById(userId), UsersDto.class);
    }
    @Override
    public String deleteUser(Integer userId) {

        Users user = repo.findById(userId).get();
        if (user != null)
            repo.deleteById(userId);
        else
            throw new NotFoundException("User with id : '" + userId + "' not Exist");

        return  "User with id : '" + userId + "' deleted Successfully";
    }


//    Users findByUsername(String username);
    @Override
    public Boolean findByUsername(UserValidate user){

        //mapper.map(repo.save(this.mapper.map(countryDto, Country.class)), CountryDto.class);

        Users storedUser = repo.findByUserName(user.getUserName()).get();
*/
/*
        if (storedUser != null && storedUser.getUserName().equals("GreenSoft") && storedUser.getPassword().equals("App")) {
            return true;
        }*//*


        if (user.getUserName().equals("GreenSoft") && user.getPassword().equals("App")) {
            return true;
        }

        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Users lodaUserByUserName(String userName) {
        return null;
    }

}
*/
