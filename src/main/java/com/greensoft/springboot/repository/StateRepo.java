package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepo extends JpaRepository<State,Integer> {

    Optional<State> findByStateName(String userName);
    Optional<State> findByStateId(Integer id);
}

