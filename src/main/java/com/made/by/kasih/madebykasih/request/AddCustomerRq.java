package com.made.by.kasih.madebykasih.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.request.body.ReqCustomer;

public class AddCustomerRq {
	@JsonProperty("body")
	public ReqCustomer reqCustomer;
}