package com.shirtsshoes.dao;

import java.util.List;

import com.shirtsshoes.bean.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	public void addProduct(Product p);
	public Product getProduct(Integer pid);
	public void deleteProduct(Integer pid);
	public void updateProduct(Product p);
	
}
