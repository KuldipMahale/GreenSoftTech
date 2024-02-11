package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.State;
import lombok.Data;

@Data
public class AreaDto {

    private Integer areaId;

    private String areaName;

    private String description;

    private City city;

    private State state;
}
