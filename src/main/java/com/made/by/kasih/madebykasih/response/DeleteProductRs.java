package com.made.by.kasih.madebykasih.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResDeleteProduct;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class DeleteProductRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public ResDeleteProduct resDeleteProduct;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public ResDeleteProduct getResDeleteProduct() {
		return resDeleteProduct;
	}
	public void setResDeleteProduct(ResDeleteProduct resDeleteProduct) {
		this.resDeleteProduct = resDeleteProduct;
	}
}