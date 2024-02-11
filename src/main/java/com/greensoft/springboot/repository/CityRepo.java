package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Integer> {

    City findByCityName(String cityName);
}
