package com.shirtsshoes.dao.restclientimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.shirtsshoes.bean.Customer;
import com.shirtsshoes.dao.CustomerDao;

@Repository
public class CustomerRestDaoImpl implements CustomerDao {


	@Inject
	private RestTemplate restTemplate;
	
	
	@Override
	public List<Customer> getCustomers() {
		Customer[] customers = restTemplate.getForObject("http://localhost:8082/ssapi/customers", Customer[].class);
		return Arrays.asList(customers);
	}

	
	
	@Override
	public void addCustomer(Customer customer) {
		restTemplate.put("http://localhost:8082/ssapi/customers", customer);
	}

	@Override
	public Customer getCustomer(Integer cid) {
		Map<String,Integer> params = new HashMap<>();
		params.put("id", cid);
		return restTemplate.getForObject("http://localhost:8082/ssapi/customers/{id}", Customer.class,params);
	}
	
	
	@Override
	public void updateCustomer(Customer customer) {
		restTemplate.postForObject("http://localhost:8082/ssapi/customers", customer, Customer.class);
	}

	
	
	@Override
	public void deleteCustomer(Integer cid) {
		Map<String,Integer> params = new HashMap<>();
		params.put("id", cid);
		restTemplate.delete("http://localhost:8082/ssapi/customers/{id}", params);
	}

	

	

}
