package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.State;
import lombok.Data;

@Data
public class CityDto {

    private Integer cityId;
    private String cityName;
    private String description;
    private Integer status;
    private State state;


}
