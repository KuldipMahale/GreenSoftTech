package com.greensoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greensoft.springboot.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

	public Customers findByCustomerId(Long customerId);

}
