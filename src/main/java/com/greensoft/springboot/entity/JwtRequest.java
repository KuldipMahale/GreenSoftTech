package com.greensoft.springboot.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JwtRequest {

    private String userName;

    private String password;
}
