package com.shirtsshoes.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shirtsshoes.bean.Customer;
import com.shirtsshoes.service.CustomerService;

@Controller
public class CustomerController {

	@Inject
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public String listCustomers(Model model){
		model.addAttribute("customers", customerService.getCustomers());
		return "customer-list";
	}
	
	@RequestMapping(value="/customer/add",method=RequestMethod.GET)
	public String addNewCustomer(Model model,Customer customer){
		return "customer-detail";
	}
	
	@RequestMapping(value="/customer/add",method=RequestMethod.POST)
	public String addNewCustomer(@Valid Customer customer,BindingResult result){
		
		if(result.hasErrors()) 
			return "forward:/customer/add";
		
		customerService.addCustomer(customer);
		return "redirect:/customer";
	}
	
	@RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
	public String editCustomer(@PathVariable int id,Model model){
		model.addAttribute("customer",customerService.getCustomer(id));
		return "customer-detail";
	}
	
	@RequestMapping(value="/customer/{id}",method=RequestMethod.POST)
	public String updateCustomer(Customer customer,BindingResult result){
		customerService.updateCustomer(customer);
		return "redirect:/customer";
	}
	
	
	@RequestMapping("/customer/{id}/delete")
	public String deleteCustomer(@PathVariable int id){
		customerService.deleteCustomer(id);
		return "redirect:/customer";
	}
	
}
