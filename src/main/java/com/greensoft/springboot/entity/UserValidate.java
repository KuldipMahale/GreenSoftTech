package com.greensoft.springboot.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserValidate {

    private String userName;
    private String password;


}
