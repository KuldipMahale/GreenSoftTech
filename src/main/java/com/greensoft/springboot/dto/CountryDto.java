package com.greensoft.springboot.dto;

import javax.validation.constraints.NotEmpty;


public class CountryDto {


    @NotEmpty
    private Long countryId;

    @NotEmpty
    private String countryName;

    private String discription;

    @NotEmpty
    private Boolean status;

}
