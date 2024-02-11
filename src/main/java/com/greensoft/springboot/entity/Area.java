package com.greensoft.springboot.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer areaId;

    private String areaName;


    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private City city;



//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "stateId", insertable = true, updatable = true)
//    @Fetch(FetchMode.JOIN)
//    private State state;
}
