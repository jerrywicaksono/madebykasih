package com.made.by.kasih.madebykasih.dto;

import java.io.Serializable;

import com.made.by.kasih.madebykasih.core.BaseSerializable;
import com.made.by.kasih.madebykasih.model.MbkCoreUser;

public class MbkUserAdminDto implements Serializable, BaseSerializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String msisdn;
	private String email;
	private String address;
	private String username;
	private String password;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MbkUserAdminDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", msisdn="
				+ msisdn + ", email=" + email + ", address=" + address + ", username=" + username + ", password="
				+ password + "]";
	}

	public MbkCoreUser convertToCoreUser(MbkUserAdminDto dto){
		MbkCoreUser mbkCoreUser = new MbkCoreUser();
		mbkCoreUser.setFirstName(dto.getFirstName());
		mbkCoreUser.setLastName(dto.getLastName());
		mbkCoreUser.setAddress(dto.getAddress());
		mbkCoreUser.setMsisdn(dto.getMsisdn());
		mbkCoreUser.setEmail(dto.getEmail());
		return mbkCoreUser;
	}
	
	public MbkUserAdminDto convertFromCoreUser(MbkCoreUser model){
		MbkUserAdminDto dto = new MbkUserAdminDto();
		dto.setFirstName(model.getFirstName());
		dto.setLastName(model.getLastName());
		dto.setAddress(model.getAddress());
		dto.setMsisdn(model.getMsisdn());
		dto.setEmail(model.getEmail());
		return dto;
	}
}