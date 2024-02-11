package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.DepartmentDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto updateDepartment(DepartmentDto departmentDto,Integer deptId);

    public List<DepartmentDto> getAllDepartment();

    public DepartmentDto getDepartment(Integer deptId);

    public String deleteDepartment(Integer deptId);

    Department findByDeptCode(String deptCode);
}
