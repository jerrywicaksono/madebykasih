package com.made.by.kasih.madebykasih.response.status;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResStatus {
	@JsonProperty("code") 
	private String code;

	@JsonProperty("description") 
	private String description;

	@JsonProperty("datetime") 
	private Date datetime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}