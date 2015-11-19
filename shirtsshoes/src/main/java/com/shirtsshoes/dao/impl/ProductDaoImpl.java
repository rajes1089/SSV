package com.shirtsshoes.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Inject
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Product order by id").setCacheable(true);
		return (List<Product>)q.list();
	}

	@Override
	public void addProduct(Product p) {
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public Product getProduct(Integer pid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);
	}

	@Override
	public void updateProduct(Product p) {
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public void deleteProduct(Integer pid) {
		Product p = (Product) sessionFactory.getCurrentSession().get(Product.class, pid);
		sessionFactory.getCurrentSession().delete(p);
	}

}
