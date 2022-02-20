package com.made.by.kasih.madebykasih.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResProductCategory;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class GetAllProductCategoryRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public List<ResProductCategory> resProductCategory;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public List<ResProductCategory> getResProductCategory() {
		return resProductCategory;
	}
	public void setResProductCategory(List<ResProductCategory> resProductCategory) {
		this.resProductCategory = resProductCategory;
	}
}