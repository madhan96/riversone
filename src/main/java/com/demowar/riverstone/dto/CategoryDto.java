package com.demowar.riverstone.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDto {
	
	@NotBlank(message = "The Category name must be provided")
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
