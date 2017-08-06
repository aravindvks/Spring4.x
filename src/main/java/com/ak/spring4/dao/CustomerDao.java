package com.ak.spring4.dao;

import java.util.List;

import com.ak.spring4.model.Customer;

public interface CustomerDao {
	
		Customer findById(int id);
	 
	    void saveCustomer(Customer customer);
	     
	    void deleteCustomerByMobilePhone(String mobile_phone);
	     
	    List<Customer> findAllCustomers();
	 
	    Customer findCustomerByMobilePhone(String mobile_phone);
}
