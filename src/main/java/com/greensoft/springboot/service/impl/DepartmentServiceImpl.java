package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.DepartmentDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Department;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CityRepo;
import com.greensoft.springboot.repository.DepartmentRepo;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo repo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto deptDto) {
       return  mapper.map(repo.save(this.mapper.map(deptDto, Department.class)), DepartmentDto.class);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto dept, Integer deptId) {
        Department existingDept = repo.findById(deptId).get();
        if(repo.findById(deptId).isPresent() && existingDept != null) {
            existingDept.setDeptCode(dept.getDeptCode());
            existingDept.setDescription(dept.getDescription());
//            existingDept.setLocation(dept.getLocation());
            return  mapper.map(repo.save(existingDept), DepartmentDto.class);
        } else {
            throw new NotFoundException("Dept Not Found with Dept Id = " + deptId);
        }
    }


    @Override
    public List<DepartmentDto> getAllDepartment() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("Department are Not Found");
        return repo.findAll().stream().map(dept -> mapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartment(Integer deptId) {

        Department dept = repo.findById(deptId).orElseThrow(() -> new NotFoundException("City Not Found with State Id = " + deptId));
        return mapper.map(dept, DepartmentDto.class);

    }

    @Override
    public String deleteDepartment(Integer deptId) {
        repo.findById(deptId).get();
        if(repo.findById(deptId).get() != null) {
            repo.deleteById(deptId);
            return "Deleted Successfuly with Dept Id :: " + deptId;
        } else {
            throw new NotFoundException("Dept Not Available with deptId = " + deptId);
        }
    }

    @Override
    public Department findByDeptCode(String cityName){
        return repo.findByDeptCode(cityName);
    }
}
