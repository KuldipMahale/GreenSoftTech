package com.greensoft.springboot.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UsersDto {


    @NotEmpty
    private Long userId;
    private String userName;
    @Size(min = 6,max = 10)
    private String password;
    @Email
    private String  email;
    @Size(min = 10, max = 10)

    private Long mobileNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer discount;
    private String address;
    private String area;
    private String city;
    private String district;
    private String state;
    private String country;
    private String countryCode;
    private String status;
}
