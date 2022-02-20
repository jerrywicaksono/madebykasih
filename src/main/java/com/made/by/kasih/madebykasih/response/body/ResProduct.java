package com.made.by.kasih.madebykasih.response.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResProduct {
	@JsonProperty("productCode") 
	private String productCode;
	
	@JsonProperty("productName") 
	private String productName;
	
	@JsonProperty("productQty") 
	private String productQty;
	
	@JsonProperty("productCategory") 
	private String productCategory;
	
	@JsonProperty("productColor") 
	private int productColor;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductQty() {
		return productQty;
	}

	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductColor() {
		return productColor;
	}

	public void setProductColor(int productColor) {
		this.productColor = productColor;
	}
}