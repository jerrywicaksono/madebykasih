package com.made.by.kasih.madebykasih.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResProduct;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class GetAllProductRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public List<ResProduct> resProduct;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public List<ResProduct> getResProduct() {
		return resProduct;
	}
	public void setResProduct(List<ResProduct> resProduct) {
		this.resProduct = resProduct;
	}
}