package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "countrytab")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryId")
    private Long countryId;

    @Column(name = "countryName",unique = true)
    private String countryName;

    @Column(name = "description")
    private String discription;

    @Column(name = "status")
    private Integer status;
//
//    @OneToMany(targetEntity = State.class, mappedBy = "stateId", orphanRemoval = false, fetch = FetchType.LAZY)
//    private Set<State> states;

}
