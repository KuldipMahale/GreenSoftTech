package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Green;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenRepository extends JpaRepository<Green,Integer> {

}
