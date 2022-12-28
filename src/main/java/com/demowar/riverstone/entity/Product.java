package com.demowar.riverstone.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Product {
	
	@Id
	@JsonAlias({"id","product_id"})
	private String productId;
	
	@Transient
	public static final String Product_Seq_Name="product_seq";
	
	@NotBlank(message = "The Product category must be provided")
	@DocumentReference
	private Category category;
	
	@NotBlank(message = "The Product name must be provided")
	private String productName;
	
	@NotNull(message =  "The Product price must be provided")
	@Min(value=0,message = "The Product price must be atleast 0")
	private BigInteger price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}
}
