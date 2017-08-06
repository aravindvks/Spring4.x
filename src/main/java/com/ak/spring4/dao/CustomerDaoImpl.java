package com.ak.spring4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ak.spring4.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	@Override
	public Customer findById(int id) {
		getByKey(id);
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	@Override
	public void deleteCustomerByMobilePhone(String mobile_phone) {
		Query query = getSession().createQuery("delete from customer where mobile_phone = :mobile_phone");
		query.setString("mobile_phone", mobile_phone);
		query.executeUpdate();
	}

	@Override
	public List<Customer> findAllCustomers() {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	}

	@Override
	public Customer findCustomerByMobilePhone(String mobile_phone) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("mobile_phone", mobile_phone));
		return (Customer) criteria.uniqueResult();
	}
		
	
}
