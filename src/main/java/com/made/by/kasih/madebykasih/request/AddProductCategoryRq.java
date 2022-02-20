package com.made.by.kasih.madebykasih.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.request.body.ReqProduct;
import com.made.by.kasih.madebykasih.request.body.ReqProductCategory;

public class AddProductCategoryRq {
	@JsonProperty("body")
	public ReqProductCategory reqProductCategory;

}