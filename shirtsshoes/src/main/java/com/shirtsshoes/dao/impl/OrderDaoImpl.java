package com.shirtsshoes.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shirtsshoes.bean.Order;
import com.shirtsshoes.dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Inject
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrders() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Order order by id").setCacheable(true);
		return (List<Order>)q.list();
	}

	@Override
	public void addOrder(Order o) {
		sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public Order getOrder(Integer oid) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, oid);
	}

	@Override
	public void updateOrder(Order o) {
		sessionFactory.getCurrentSession().update(o);
	}

	@Override
	public void deleteOrder(Integer oid) {
		Order o = (Order) sessionFactory.getCurrentSession().get(Order.class, oid);
		sessionFactory.getCurrentSession().delete(o);
	}

}
