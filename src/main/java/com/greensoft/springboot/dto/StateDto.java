package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Country;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class StateDto {

    private Integer stateId;

    @NotBlank
    private String stateName;

    private Country country;

    private String discription;

    private Integer status;

    private String countryName;

}
