package com.greensoft.springboot.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deptId;

    private String deptCode;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locId", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Location location;


}
