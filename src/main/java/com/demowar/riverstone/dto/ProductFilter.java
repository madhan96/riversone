package com.demowar.riverstone.dto;

import java.util.List;

public class ProductFilter {
	
	private List<String> categoryIds;
	
	private Integer offset;
	
	private Integer size;
	
	public List<String> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<String> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


}
