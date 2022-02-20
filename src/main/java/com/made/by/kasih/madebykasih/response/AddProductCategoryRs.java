package com.made.by.kasih.madebykasih.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResProductCategory;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class AddProductCategoryRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public ResProductCategory resProductCategory;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public ResProductCategory getResProductCategory() {
		return resProductCategory;
	}
	public void setResProductCategory(ResProductCategory resProductCategory) {
		this.resProductCategory = resProductCategory;
	}
}