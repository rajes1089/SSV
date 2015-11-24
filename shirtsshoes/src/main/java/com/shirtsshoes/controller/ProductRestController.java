package com.shirtsshoes.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shirtsshoes.bean.Product;
import com.shirtsshoes.service.ProductService;

@Controller
@RequestMapping(value="/api/products")
public class ProductRestController {

	@Inject
	private ProductService productService;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Product> listProducts(){
		return productService.getProducts();
	}
	
	
}
