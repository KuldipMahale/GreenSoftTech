package com.greensoft.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

//    @ManyToMany
//    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "users",referencedColumnName = "id"))
//    private Set<Role> roles = new HashSet<>();

}
