package com.made.by.kasih.madebykasih.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.made.by.kasih.madebykasih.response.body.ResUserAdmin;
import com.made.by.kasih.madebykasih.response.status.ResStatus;

public class AddUserAdminRs {
	@JsonProperty("status")
	public ResStatus resStatus;
	@JsonProperty("body")
	public ResUserAdmin resUserAdmin;
	
	public ResStatus getResStatus() {
		return resStatus;
	}
	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}
	public ResUserAdmin getResUserAdmin() {
		return resUserAdmin;
	}
	public void setResUserAdmin(ResUserAdmin resUserAdmin) {
		this.resUserAdmin = resUserAdmin;
	}
}