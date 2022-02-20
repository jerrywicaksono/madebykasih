package com.made.by.kasih.madebykasih.response.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResDeleteProduct {
	@JsonProperty("deleted") 
	private boolean deleted;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}