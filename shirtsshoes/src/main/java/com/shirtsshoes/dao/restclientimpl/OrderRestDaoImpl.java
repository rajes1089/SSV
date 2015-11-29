package com.shirtsshoes.dao.restclientimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.shirtsshoes.bean.Order;
import com.shirtsshoes.dao.OrderDao;

@Repository
public class OrderRestDaoImpl implements OrderDao {


	@Inject
	private RestTemplate restTemplate;
	
	
	@Override
	public List<Order> getOrders() {
		Order[] orderArray = restTemplate.getForObject("http://localhost:8082/ssapi/orders/", Order[].class);
		return Arrays.asList(orderArray);
	}

	@Override
	public void addOrder(Order order) {
		restTemplate.put("http://localhost:8082/ssapi/orders", order);
	}

	
	@Override
	public Order getOrder(Integer pid) {
		Map<String,Integer> param = new HashMap<>();
		param.put("id", pid);
		return restTemplate.getForObject("http://localhost:8082/ssapi/orders/{id}", Order.class,param);
	}
	
	
	@Override
	public void updateOrder(Order order) {
		restTemplate.postForObject("http://localhost:8082/ssapi/orders", order, Order.class);
	}
	

	@Override
	public void deleteOrder(Integer pid) {
		Map<String,Integer> param = new HashMap<>();
		param.put("id", pid);
		restTemplate.delete("http://localhost:8082/ssapi/orders/{id}", param);
	}

}
