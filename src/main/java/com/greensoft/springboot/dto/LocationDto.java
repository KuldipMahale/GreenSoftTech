package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Area;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;


@Data
public class LocationDto {

    private Integer locId;
    private String locName;
    private String locCode;
    private String address;
    private Long phoneNo;
    private String email;
    private Area area;
}
