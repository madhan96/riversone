package com.demowar.riverstone.service;

import java.util.List;

import com.demowar.riverstone.dto.ProductFilter;
import com.demowar.riverstone.entity.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public List<Product> getAllProductWithFilter(ProductFilter filter);

}
