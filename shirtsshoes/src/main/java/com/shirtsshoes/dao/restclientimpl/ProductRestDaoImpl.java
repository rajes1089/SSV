package com.shirtsshoes.dao.restclientimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.dao.ProductDao;

@Repository
public class ProductRestDaoImpl implements ProductDao{

	@Inject
	private RestTemplate restTemplate;



	@Override
	public List<Product> getProducts() {
		ResponseEntity<Product[]> restResponse = restTemplate.getForEntity("http://localhost:8082/ssapi/products", Product[].class);
		List<Product> products = Arrays.asList(restResponse.getBody());
		return products;
	}

	@Override
	public List<Product> getProducts(String Name) {
		Map<String,String> parms = new HashMap<>();
		parms.put("searchString", Name);
		ResponseEntity<Product[]> restResponse = restTemplate.getForEntity("http://localhost:8082/ssapi/products/{searchString}",Product[].class,parms);
		return Arrays.asList(restResponse.getBody());
	}

	
	
	@Override
	public void addProduct(Product p) {
		restTemplate.put("http://localhost:8082/ssapi/products", p);
	}
	
	
	@Override
	public Product getProduct(Integer pid) {
		Map<String,Integer> parms = new HashMap<>();
		parms.put("id", pid);
		return restTemplate.getForObject("http://localhost:8082/ssapi/products/{id}", Product.class,parms);
	}
	
	
	@Override
	public void updateProduct(Product product) {
		restTemplate.postForObject("http://localhost:8082/ssapi/products", product, Product.class);
	}
	

	@Override
	public void deleteProduct(Integer pid) {
		Map<String,Integer> parms = new HashMap<>();
		parms.put("id", pid);
		restTemplate.delete("http://localhost:8082/ssapi/products/{id}", parms);
	}

}
