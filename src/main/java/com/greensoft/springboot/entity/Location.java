package com.greensoft.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locId;
    @Column(unique = true)
    private String locName;
    @Column(unique = true)
    private String locCode;
    private String address;
    private Long phoneNo;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaId", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Area area;

}