package com.demowar.riverstone.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demowar.riverstone.entity.Category;

public interface CategoryRepository extends MongoRepository<Category,String>{
	
	public List<Category> findAll();

}
