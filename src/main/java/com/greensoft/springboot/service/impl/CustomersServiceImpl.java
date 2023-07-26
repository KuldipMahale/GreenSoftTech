package com.greensoft.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.exception.AlreadyExistsException;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CustomersRepository;
import com.greensoft.springboot.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersRepository customerRepository;

	public Customers saveOrUpdateCustomer(Customers customers) {
		Customers newCustomer;
		Customers existingCustomer = null;

		if (customers.getCustomerId() != null)
			existingCustomer = customerRepository.findByCustomerId(customers.getCustomerId());

		if (existingCustomer == null)
			newCustomer = customerRepository.save(customers);
		else
			throw new AlreadyExistsException(
					"Customer with id : '" + customers.getCustomerId() + "' is Already Exist !");
		return newCustomer;
	}

	public List<Customers> getAllCustomers() {
		List<Customers> customersList = customerRepository.findAll();
		if (customersList.isEmpty())
			throw new NotFoundException("Customers Not Available");
		return customersList;
	}

	public Customers getCustomer(Long customerId) {
		Customers customer = customerRepository.findByCustomerId(customerId);
		if (customer == null)
			throw new NotFoundException("Customer with id : '" + customerId + "' not Exist");
		return customer;
	}

	@Override
	public String deleteCustomer(Long customerId) {
		Customers customer = customerRepository.findByCustomerId(customerId);
		if (customer != null)
			customerRepository.deleteById(customerId);
		else
			throw new NotFoundException("Customer with id : '" + customerId + "' not Exist");
		return "Customer with id : '" + customerId + "' deleted Successfully";

	}

}
