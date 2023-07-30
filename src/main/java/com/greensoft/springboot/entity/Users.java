package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String  email;
    @Column(name = "mobile_no")
    private Long mobileNo;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "address")
    private String address;
    @Column(name = "area")
    private String area;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "status")
    private String status;



}
