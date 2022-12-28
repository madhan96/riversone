package com.demowar.riverstone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demowar.riverstone.dto.ProductFilter;
import com.demowar.riverstone.entity.Product;
import com.demowar.riverstone.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("product")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public ResponseEntity<Object> saveProduct( @Valid @RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	public ResponseEntity<Object> getAllProduct( ) {
		return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@RequestMapping(value="getAllByFilter",method = RequestMethod.POST)
	public ResponseEntity<Object> getAllProduct( @RequestBody ProductFilter filter) {
		return new ResponseEntity<>(productService.getAllProductWithFilter(filter),HttpStatus.OK);
	}

}
