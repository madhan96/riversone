package com.demowar.riverstone.service;

import java.util.List;

import com.demowar.riverstone.entity.Category;

public interface CategoryService {
	public Category saveCategory(Category cat);
	
	public List<Category> getAllCategory();
}
