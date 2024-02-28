package com.greensoft.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cityId;

    private String cityName;

    private String description;

    private Integer status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stateId", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private State state;

}
