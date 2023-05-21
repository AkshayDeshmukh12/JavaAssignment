package com.nit.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable {

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private Integer pid;
			private String pname;
			private String pdescription;
			@ManyToOne(targetEntity = Category.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
			@JoinColumn(name="category_id",referencedColumnName = "CID")
			private Category category;
			public Integer getPid() {
				return pid;
			}
			public void setPid(Integer pid) {
				this.pid = pid;
			}
			public String getPname() {
				return pname;
			}
			public void setPname(String pname) {
				this.pname = pname;
			}
			public String getPdescription() {
				return pdescription;
			}
			public void setPdescription(String pdescription) {
				this.pdescription = pdescription;
			}
			public Category getCategory() {
				return category;
			}
			public void setCategory(Category category) {
				this.category = category;
			}
			@Override
			public String toString() {
				return "Product [pid=" + pid + ", pname=" + pname + ", pdescription=" + pdescription + "]";
			}
	
	
	
}
