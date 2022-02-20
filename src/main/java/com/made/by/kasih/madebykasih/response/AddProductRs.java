package com.made.by.kasih.madebykasih.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResProduct;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class AddProductRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public ResProduct resProduct;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public ResProduct getResProduct() {
		return resProduct;
	}
	public void setResProduct(ResProduct resProduct) {
		this.resProduct = resProduct;
	}
}