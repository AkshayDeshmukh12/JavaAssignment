package com.nit.dto;

import java.util.List;

import com.nit.entity.Product;

public class CategoryDTO {

	private Integer cateID;
	private String cateName;
	private String cateDesc;
	private List<ProductDTO> products;
	public Integer getCateID() {
		return cateID;
	}
	public void setCateID(Integer cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateDesc() {
		return cateDesc;
	}
	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CategoryDTO [cateID=" + cateID + ", cateName=" + cateName + ", cateDesc=" + cateDesc + ", products="
				+ products + "]";
	}
	
	
}
