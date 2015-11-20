package com.shirtsshoes.dao;

import java.util.List;

import com.shirtsshoes.bean.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	public List<Product> getProducts(String Name);
	public void addProduct(Product p);
	public Product getProduct(Integer pid);
	public void deleteProduct(Integer pid);
	public void updateProduct(Product p);
	
}
