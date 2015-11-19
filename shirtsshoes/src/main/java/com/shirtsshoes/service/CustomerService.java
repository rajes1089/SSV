package com.shirtsshoes.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shirtsshoes.bean.Customer;
import com.shirtsshoes.dao.CustomerDao;

@Transactional
@Service
public class CustomerService {

	@Inject
	private CustomerDao CustomerDao;
	
	public List<Customer> getCustomers() {
		return CustomerDao.getCustomers();
	}
	
	public Customer getCustomer(Integer pid){
		return CustomerDao.getCustomer(pid);
	}
	
	public void addCustomer(Customer p) {
		CustomerDao.addCustomer(p);
	}
	
	public void updateCustomer(Customer p) {
		CustomerDao.updateCustomer(p);
	}
	
	public void deleteCustomer(Integer pid) {
		CustomerDao.deleteCustomer(pid);
	}
}
