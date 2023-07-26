package com.greensoft.springboot.service;

import java.util.List;

import com.greensoft.springboot.entity.Customers;

public interface CustomersService {

	public Customers saveOrUpdateCustomer(Customers customers);

	public List<Customers> getAllCustomers();

	public Customers getCustomer(Long customerId);

	public String deleteCustomer(Long customerId);

}
