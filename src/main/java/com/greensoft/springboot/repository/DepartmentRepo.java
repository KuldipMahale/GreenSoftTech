package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    Department findByDeptCode(String deptCode);
}
