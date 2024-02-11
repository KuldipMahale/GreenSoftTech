package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users,Integer> {

    Optional<Users> findByUserName(String userName);
}
