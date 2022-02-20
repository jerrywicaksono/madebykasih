package com.made.by.kasih.madebykasih.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqCustomer {
	@JsonProperty("id")
	private Long id;
	
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
	
	@JsonProperty("member") 
	private boolean member;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}
}