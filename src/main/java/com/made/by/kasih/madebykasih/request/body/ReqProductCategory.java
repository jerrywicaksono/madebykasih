package com.made.by.kasih.madebykasih.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqProductCategory {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("categoryCode")
	private String categoryCode;
	
	@JsonProperty("categoryName")
	private String categoryName;

	@JsonProperty("categoryDesc")
	private String categoryDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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