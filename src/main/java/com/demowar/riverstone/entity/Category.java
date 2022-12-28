package com.demowar.riverstone.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;

@Document(collection = "category")
public class Category {
	@Id
	@JsonAlias({"id","category_id"})
	private String categoryId;
	
	private String categoryName;
	
	@Transient
	public static final String Category_Seq_Name="category_seq";
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
