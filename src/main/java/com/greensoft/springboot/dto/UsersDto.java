package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Location;
import lombok.Data;


@Data
public class UsersDto {


    private Integer userId;
    private String userName;
    private String password;
    private String  email;


    private Long mobileNo;
    private String fullName;
    private String address;


    private String empNo;

    private String profilePhoto;

    private String hospitalName;

    private Location location;
}
