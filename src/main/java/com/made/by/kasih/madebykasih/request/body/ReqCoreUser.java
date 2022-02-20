package com.made.by.kasih.madebykasih.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqCoreUser {
	@JsonProperty("firstName") 
	private String firstName;

	@JsonProperty("lastName") 
	private String lastName;

	@JsonProperty("msisdn") 
	private String msisdn;
	
	@JsonProperty("email") 
	private String email;
	
	@JsonProperty("address") 
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}