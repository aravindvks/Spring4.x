package com.ak.spring4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.spring4.dao.CustomerDao;
import com.ak.spring4.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
		
	@Autowired
    private CustomerDao dao;

	@Override
	public Customer findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer entity = dao.findById(customer.getId());
		if(entity != null){
			entity.setFirst_name(customer.getFirst_name());
			entity.setLast_name(customer.getLast_name());
			entity.setCompany(customer.getCompany());
			entity.setMobile_phone(customer.getMobile_phone());
		}
	}

	@Override
	public void deleteCustomerByMobilePhone(String mobile_phone) {
		dao.deleteCustomerByMobilePhone(mobile_phone);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return dao.findAllCustomers();
	}

	@Override
	public Customer findByCustomerMobilePhone(String mobile_phone) {
		return dao.findCustomerByMobilePhone(mobile_phone);
	}

	@Override
	public boolean isCustomerMobilePhoneUnique(Integer id, String mobile_phone) {
		Customer customer = findByCustomerMobilePhone(mobile_phone);
		 return ( customer == null || ((id != null) && (customer.getId() == id)));
	}
		
}
