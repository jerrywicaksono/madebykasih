package com.made.by.kasih.madebykasih.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.request.body.ReqCoreUser;

public class AddUserAdminRq {
	@JsonProperty("body")
	public ReqCoreUser reqCoreUser;

	public ReqCoreUser getReqCoreUser() {
		return reqCoreUser;
	}

	public void setReqCoreUser(ReqCoreUser reqCoreUser) {
		this.reqCoreUser = reqCoreUser;
	}
}