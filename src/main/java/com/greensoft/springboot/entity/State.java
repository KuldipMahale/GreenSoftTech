package com.greensoft.springboot.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statetab")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stateId")
    private Integer stateId;

    @Column(name = "stateName",unique = true)
    private String stateName;

    @Column(name = "description")
    private String discription;

    @Column(name = "status")
    private Integer status;

//    @OneToOne
//    @JoinColumn(name = "countryId")
//    private Country country;

//    @Column(unique = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Country country;

    private String countryName;

}
