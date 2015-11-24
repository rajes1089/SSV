package com.shirtsshoes.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shirtsshoes.bean.Order;
import com.shirtsshoes.service.OrderService;

@Controller
@RequestMapping(value="/api/orders")
public class OrderRestController {

	@Inject
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Order> listOrders(){
		return orderService.getOrders();
	}
	
}
