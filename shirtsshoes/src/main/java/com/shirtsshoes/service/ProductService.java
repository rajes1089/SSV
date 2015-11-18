package com.shirtsshoes.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.dao.ProductDao;

@Transactional
@Service
public class ProductService {

	@Inject
	private ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public Product getProduct(Integer pid){
		return productDao.getProduct(pid);
	}
	
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}
	
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}
	
	public void deleteProduct(Integer pid) {
		productDao.deleteProduct(pid);
	}
}
