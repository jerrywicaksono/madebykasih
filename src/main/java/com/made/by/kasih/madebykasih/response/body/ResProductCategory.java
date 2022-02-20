package com.made.by.kasih.madebykasih.response.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResProductCategory {
	@JsonProperty("categoryCode") 
	private String categoryCode;
	
	@JsonProperty("categoryName") 
	private String categoryName;
	
	@JsonProperty("categoryDesc") 
	private String categoryDesc;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
}