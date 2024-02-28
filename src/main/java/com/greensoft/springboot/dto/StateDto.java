package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Country;
import lombok.Data;


@Data
public class StateDto {

    private Integer stateId;

    private String stateName;

    private Country country;

    private String discription;

    private Integer status;

    private String countryName;

}
