package com.stosh.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class GeneralUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int generalUserId;
	private String generalUserName;
	private String generalUserPassword;
	
	@ManyToMany(mappedBy="userList")
	List<Product> productList;

	public int getGeneralUserId() {
		return generalUserId;
	}

	public void setGeneralUserId(int generalUserId) {
		this.generalUserId = generalUserId;
	}

	public String getGeneralUserName() {
		return generalUserName;
	}

	public void setGeneralUserName(String generalUserName) {
		this.generalUserName = generalUserName;
	}

	public String getGeneralUserPassword() {
		return generalUserPassword;
	}

	public void setGeneralUserPassword(String generalUserPassword) {
		this.generalUserPassword = generalUserPassword;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
	
}
