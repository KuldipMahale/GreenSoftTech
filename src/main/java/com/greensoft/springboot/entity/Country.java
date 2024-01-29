package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countrytab")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryId")
    private Long countryId;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "description")
    private String discription;

    @Column(name = "status")
    private Integer status;


}
