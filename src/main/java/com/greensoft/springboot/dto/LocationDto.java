package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Area;
import lombok.Data;

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
