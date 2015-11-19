package com.shirtsshoes.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shirtsshoes.bean.Customer;
import com.shirtsshoes.dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Inject
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Customer order by id");
		return (List<Customer>)q.list();
	}

	@Override
	public void addCustomer(Customer c) {
		sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public Customer getCustomer(Integer cid) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, cid);
	}

	@Override
	public void updateCustomer(Customer c) {
		sessionFactory.getCurrentSession().update(c);
	}

	@Override
	public void deleteCustomer(Integer cid) {
		Customer c = (Customer) sessionFactory.getCurrentSession().get(Customer.class, cid);
		sessionFactory.getCurrentSession().delete(c);
	}

}
