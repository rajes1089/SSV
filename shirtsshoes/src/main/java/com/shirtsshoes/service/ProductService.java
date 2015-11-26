package com.shirtsshoes.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.dao.ProductDao;

@Service
public class ProductService {

	@Inject @Qualifier("productRestDaoImpl")
	private ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	public List<Product> getProducts(String name) {
		return productDao.getProducts(name);
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
