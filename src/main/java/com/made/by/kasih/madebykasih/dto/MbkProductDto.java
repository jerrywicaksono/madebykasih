package com.made.by.kasih.madebykasih.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.made.by.kasih.madebykasih.core.BaseSerializable;
import com.made.by.kasih.madebykasih.model.MbkProduct;

public class MbkProductDto implements Serializable, BaseSerializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String productCode;
	private String productName;
	private String productQty;
	private String productCategory;
	private int productColor;
	private String orderBy;
	private String order;
	private List<MbkProduct> listProduct = new ArrayList<MbkProduct>();
	
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public List<MbkProduct> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<MbkProduct> listProduct) {
		this.listProduct = listProduct;
	}

	@Override
	public String toString() {
		return "MbkProductDto [id=" + id + ", productCode=" + productCode + ", productName=" + productName
				+ ", productQty=" + productQty + ", productCategory=" + productCategory + ", productColor="
				+ productColor + ", orderBy=" + orderBy + ", order=" + order + "]";
	}
	
	public MbkProduct convertToProduct(MbkProductDto dto){
		MbkProduct mbkProduct = new MbkProduct();
		mbkProduct.setProductCode(dto.getProductCode());
		mbkProduct.setProductName(dto.getProductName());
		mbkProduct.setProductCategory(dto.getProductCategory());
		mbkProduct.setProductColor(dto.getProductColor());
		mbkProduct.setProductQty(dto.getProductQty());
		return mbkProduct;
	}
	
	public MbkProductDto convertFromProduct(MbkProduct model){
		MbkProductDto dto = new MbkProductDto();
		dto.setProductCode(model.getProductCode());
		dto.setProductName(model.getProductName());
		dto.setProductCategory(model.getProductCategory());
		dto.setProductColor(model.getProductColor());
		dto.setProductQty(model.getProductQty());
		return dto;
	}
}