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
@Table(name = "mbk_product_category")
@EntityListeners(AuditingEntityListener.class)
public class MbkProductCategory extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name="category_code")
	private String categoryCode;
	
	@NotBlank
	@Column(name="category_name")
	private String categoryName;

	@NotBlank
	@Column(name="category_desc")
	private String categoryDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Override
	public String toString() {
		return "MbkProductCategory [id=" + id + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName
				+ ", categoryDesc=" + categoryDesc + "]";
	}
}