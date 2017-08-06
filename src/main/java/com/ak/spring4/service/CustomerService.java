package com.ak.spring4.service;

import java.util.List;

import com.ak.spring4.model.Customer;

public interface CustomerService {

		Customer findById(int id);
		
		void saveCustomer(Customer customer);
		
		void updateCustomer(Customer customer);
		
		void deleteCustomerByMobilePhone(String mobile_phone);
		
		List<Customer> findAllCustomers();
		
		Customer findByCustomerMobilePhone(String mobile_phone);
		
		boolean isCustomerMobilePhoneUnique(Integer id, String mobile_phone);
		
}
