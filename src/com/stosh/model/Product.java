package com.stosh.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productCode;
	private String productPrice;
	private String productImage;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category = new Category();

	@ManyToMany
	@JoinTable(name="generalUserProduct", joinColumns=@JoinColumn(name="productId"), inverseJoinColumns=@JoinColumn(name="generalUserId"))
	List<GeneralUser> userList;
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<GeneralUser> getUserList() {
		return userList;
	}

	public void setUserList(List<GeneralUser> userList) {
		this.userList = userList;
	}
	
	
	
	
	
}
