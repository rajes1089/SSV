package com.shirtsshoes.controller;

import java.sql.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.service.ProductService;

@Controller
public class ProductController {

	@Inject
	private ProductService productService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder wdb){
		//wdb.setAllowedFields(new String[]{""});
	}
	
	
	
	
	
	@RequestMapping("/product")
	public String listProducts(Model model){
		model.addAttribute("products", productService.getProducts());
		return "product-list";
	}
	
	@RequestMapping("/product/search")
	public String searchProducts(Model model,@RequestParam("productSearch") String pName){
		model.addAttribute("products", productService.getProducts(pName));
		return "product-list";
	}
	
	
	@RequestMapping(value="/product/add",method=RequestMethod.GET)
	public String addNewProduct(Model model,Product product){
		return "product-new";
	}
	
	@RequestMapping(value="/product/add",method=RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") @Valid Product product,BindingResult result){
		
		if(result.hasErrors()) 
			return "forward:/product/add";
		
		productService.addProduct(product);
		return "redirect:/product";
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public String editProduct(@PathVariable int id,Model model){
		model.addAttribute("product",productService.getProduct(id));
		return "product-detail";
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.POST)
	public String updateProduct(Product product,BindingResult result){
		product.setLastUpdate(new Date(new java.util.Date().getTime()));
		productService.updateProduct(product);
		return "redirect:/product";
	}
	
	
	@RequestMapping("/product/{id}/delete")
	public String deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return "redirect:/product";
	}
	
}
