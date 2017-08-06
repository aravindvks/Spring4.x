package com.ak.spring4.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.spring4.model.Customer;
import com.ak.spring4.service.CustomerService;


@RestController
public class CustomerController extends BaseController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/listcustomers")
	public List<Customer> getCustomersList(){
		return customerService.findAllCustomers();
	}
	
	@PostMapping(value = "/findcustomer")
	public ResponseEntity<Customer> findCustomer(@RequestBody String mobile_phone) throws SQLException {
		Customer customer = customerService.findByCustomerMobilePhone(mobile_phone);
		if(customer == null){
			return new ResponseEntity("No Customer found for ID " + mobile_phone, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/addcustomer")
	public ResponseEntity<Customer> addCustomer(Customer customer){
		customerService.saveCustomer(customer);
		Customer customerAdded = customerService.findByCustomerMobilePhone(customer.getMobile_phone());
		if(customerAdded == null){
			return new ResponseEntity("No Customer found for ID " + customer.getMobile_phone(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping (value = "/deletecustomer")
	public ResponseEntity<Customer> deleteCustomer(String mobile_phone){
		customerService.deleteCustomerByMobilePhone(mobile_phone);
		Customer findCustomer = customerService.findByCustomerMobilePhone(mobile_phone);
		if(findCustomer == null){
			return new ResponseEntity("No Customer found for ID " + mobile_phone , HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(findCustomer, HttpStatus.OK);
	}
}
