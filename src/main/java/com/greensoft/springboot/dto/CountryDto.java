package com.greensoft.springboot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CountryDto {


    private Long countryId;

    @NotEmpty
    @NotBlank
    private String countryName;

    @NotBlank
    private String discription;

    private Integer status;

}
