package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statetab")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stateId")
    private Long stateId;

    @Column(name = "stateName")
    private String stateName;

    @Column(name = "description")
    private String discription;

    @Column(name = "status")
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "countryId")
    private Country country;


}
