package com.demowar.riverstone.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demowar.riverstone.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	Page<Product> findAllByCategoryIn(List<String> categoryIds,Pageable page);
}
