package com.made.by.kasih.madebykasih.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResCustomer;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class GetAllCustomerRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public List<ResCustomer> resCustomer;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public List<ResCustomer> getResCustomer() {
		return resCustomer;
	}
	public void setResCustomer(List<ResCustomer> resCustomer) {
		this.resCustomer = resCustomer;
	}
}