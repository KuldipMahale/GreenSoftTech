package com.greensoft.springboot.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CountryDto {


    @NotEmpty
    private Long countryId;

    @NotEmpty
    private String countryName;

    private String discription;

    @NotEmpty
    private Boolean status;

}
