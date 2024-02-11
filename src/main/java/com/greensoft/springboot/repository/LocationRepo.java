package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location,Integer> {


    Location findByLocName(String locName);
}
