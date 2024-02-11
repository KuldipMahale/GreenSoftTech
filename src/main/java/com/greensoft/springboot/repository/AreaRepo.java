package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Area;
import com.greensoft.springboot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepo extends JpaRepository<Area,Integer> {

    Area findByAreaName(String areaName);
}
