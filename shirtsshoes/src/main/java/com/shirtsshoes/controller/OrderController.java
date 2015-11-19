package com.shirtsshoes.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shirtsshoes.bean.Order;
import com.shirtsshoes.service.OrderService;

@Controller
public class OrderController {

	@Inject
	private OrderService orderService;
	
	@RequestMapping("/order")
	public String listOrders(Model model){
		model.addAttribute("orders", orderService.getOrders());
		return "order-list";
	}
	
	@RequestMapping(value="/order/add",method=RequestMethod.GET)
	public String addNewOrder(Model model,Order order){
		return "order-detail";
	}
	
	@RequestMapping(value="/order/add",method=RequestMethod.POST)
	public String addNewOrder(@Valid Order order,BindingResult result){
		
		if(result.hasErrors()) 
			return "forward:/order/add";
		
		orderService.addOrder(order);
		return "redirect:/order";
	}
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public String editOrder(@PathVariable int id,Model model){
		model.addAttribute("order",orderService.getOrder(id));
		return "order-detail";
	}
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.POST)
	public String updateOrder(Order order,BindingResult result){
		orderService.updateOrder(order);
		return "redirect:/order";
	}
	
	
	@RequestMapping("/order/{id}/delete")
	public String deleteOrder(@PathVariable int id){
		orderService.deleteOrder(id);
		return "redirect:/order";
	}
	
}
