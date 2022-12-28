package com.demowar.riverstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demowar.riverstone.dto.ProductFilter;
import com.demowar.riverstone.entity.Product;
import com.demowar.riverstone.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProductWithFilter(ProductFilter filter) {
		// TODO Auto-generated method stub
		Pageable pagerequest = PageRequest.of(Optional.ofNullable(filter.getOffset()).orElse(0),Optional.ofNullable(filter.getSize()).orElse(0) != 0?filter.getSize():20 );
		Page<Product> page=productRepository.findAllByCategoryIn(filter.getCategoryIds(), pagerequest);
		return page.getContent();
//		return productRepository.findAllByCategoryIn(filter.getCategoryIds());
	}

}
