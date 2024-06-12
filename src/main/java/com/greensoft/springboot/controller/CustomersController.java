package com.greensoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.service.CustomersService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveNewCustomer(@RequestBody Customers customer) {
		Customers savedCustomer = customersService.saveNewCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping(value = "/edit/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateCustomer(@PathVariable Long customerId, @RequestBody Customers customer) {
		Customers updatedCustomer = customersService.updateCustomer(customerId, customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllCustomers() {
		List<Customers> allCustomers = customersService.getAllCustomers();
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCustomerById(@PathVariable Long customerId) {
		Customers allCustomers = customersService.getCustomer(customerId);
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerId) {
		String message = customersService.deleteCustomer(customerId);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

}
