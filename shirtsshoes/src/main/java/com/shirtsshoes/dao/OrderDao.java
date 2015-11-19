package com.shirtsshoes.dao;

import java.util.List;

import com.shirtsshoes.bean.Order;

public interface OrderDao {
	
	public List<Order> getOrders();
	public void addOrder(Order p);
	public Order getOrder(Integer pid);
	public void deleteOrder(Integer pid);
	public void updateOrder(Order p);
	
}
