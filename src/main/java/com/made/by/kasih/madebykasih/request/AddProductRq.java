package com.made.by.kasih.madebykasih.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.request.body.ReqProduct;

public class AddProductRq {
	@JsonProperty("body")
	public ReqProduct reqProduct;

}