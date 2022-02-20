package com.made.by.kasih.madebykasih.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "mbk_user_admin")
@EntityListeners(AuditingEntityListener.class)
public class MbkUserAdmin extends BaseModel{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(name="user_id")
	private Long userId;
	
	@NotBlank
	@Column(name="username")
	private String username;

	@NotBlank
	@Column(name="password")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "MbkUserAdmin [id=" + id + ", userId=" + userId + ", username=" + username + ", password=" + password
				+ "]";
	}
}