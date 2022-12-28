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

import com.demowar.riverstone.dto.CategoryDto;
import com.demowar.riverstone.entity.Category;
import com.demowar.riverstone.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public ResponseEntity<Object> saveCategory( @Valid @RequestBody CategoryDto category)
	{
		Category cat=new Category();
		cat.setCategoryName(category.getCategoryName());
		return new ResponseEntity<>(categoryService.saveCategory(cat),HttpStatus.OK);
	}
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	public ResponseEntity<Object> getAllCategory( ) {
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
	}
}
