package com.made.by.kasih.madebykasih.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "mbk_core_user")
@EntityListeners(AuditingEntityListener.class)
public class MbkCoreUser extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name="first_name")
	private String firstName;

	@NotBlank
	@Column(name="last_name")
	private String lastName;

	@NotBlank
	@Column(name="msisdn")
	private String msisdn;
	
	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Column(name="address")
	private String address;

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

	@Override
	public String toString() {
		return "MbkCoreUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", msisdn=" + msisdn
				+ ", email=" + email + ", address=" + address + "]";
	}
}