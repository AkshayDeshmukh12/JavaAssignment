package com.nit.dto;

import com.nit.entity.Category;

public class ProductDTO {

	private Integer id;
	private String pname;
	private String pdesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", pname=" + pname + ", pdesc=" + pdesc +"]";
	}
	
	
}
