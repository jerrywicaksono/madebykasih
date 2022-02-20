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
@Table(name = "mbk_product")
@EntityListeners(AuditingEntityListener.class)
public class MbkProduct extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name="product_code")
	private String productCode;
	
	@NotBlank
	@Column(name="product_name")
	private String productName;

	@NotBlank
	@Column(name="product_qty")
	private String productQty;
	
	@NotBlank
	@Column(name="product_category")
	private String productCategory;
	
	@NotBlank
	@Column(name="product_color")
	private int productColor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductQty() {
		return productQty;
	}

	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductColor() {
		return productColor;
	}

	public void setProductColor(int productColor) {
		this.productColor = productColor;
	}

	@Override
	public String toString() {
		return "MbkProduct [id=" + id + ", productCode=" + productCode + ", productName=" + productName
				+ ", productQty=" + productQty + ", productCategory=" + productCategory + ", productColor="
				+ productColor + "]";
	}
}