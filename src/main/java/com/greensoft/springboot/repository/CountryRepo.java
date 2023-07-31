package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Long> {
}
