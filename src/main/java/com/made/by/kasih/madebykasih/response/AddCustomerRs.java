package com.made.by.kasih.madebykasih.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResCustomer;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class AddCustomerRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public ResCustomer resCustomer;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public ResCustomer getResCustomer() {
		return resCustomer;
	}
	public void setResCustomer(ResCustomer resCustomer) {
		this.resCustomer = resCustomer;
	}
}
