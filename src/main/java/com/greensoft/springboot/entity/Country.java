package com.greensoft.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;

    private String countryName;

    private String discription;

    private Boolean status;

}
