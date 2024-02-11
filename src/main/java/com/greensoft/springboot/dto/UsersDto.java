package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Location;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UsersDto {


    private Integer userId;
    private String userName;
    @Size(min = 6,max = 10)
    private String password;
    @Email
    private String  email;


    private Long mobileNo;
    private String fullName;
    private String address;


    private String empNo;

    private String profilePhoto;

    private String hospitalName;

    private Location location;
}
