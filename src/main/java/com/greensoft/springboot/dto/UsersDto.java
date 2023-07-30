package com.greensoft.springboot.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UsersDto {

    private Long userId;
    private String userName;
    private String password;
    private String  email;
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
