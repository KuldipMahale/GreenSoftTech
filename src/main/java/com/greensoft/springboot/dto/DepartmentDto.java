package com.greensoft.springboot.dto;

import com.greensoft.springboot.entity.Location;
import lombok.Data;

@Data
public class DepartmentDto {

    private Integer deptId;

    private String deptCode;

    private String description;

    private Location location;
}