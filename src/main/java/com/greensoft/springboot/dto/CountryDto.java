package com.greensoft.springboot.dto;

import lombok.Data;


@Data
public class CountryDto {


    private Long countryId;

    private String countryName;

    private String discription;

    private Integer status;

}
