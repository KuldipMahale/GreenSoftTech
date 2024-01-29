package com.greensoft.springboot.repository;

import com.greensoft.springboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {

    Users findByUserName(String userName);
}
