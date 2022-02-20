package com.made.by.kasih.madebykasih.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.request.body.ReqProduct;

public class UpdateProductRq {
	@JsonProperty("body")
	public ReqProduct reqProduct;

	public ReqProduct getReqProduct() {
		return reqProduct;
	}

	public void setReqProduct(ReqProduct reqProduct) {
		this.reqProduct = reqProduct;
	}
}