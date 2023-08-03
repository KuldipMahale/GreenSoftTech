package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countrytab")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;

    private String countryName;

    private String discription;

    private Boolean status;

}
