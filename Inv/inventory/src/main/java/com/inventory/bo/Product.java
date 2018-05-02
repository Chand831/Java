package com.inventory.bo;

/**
 * This class is used as Business object for Product Information
 * 
 *
 */
public class Product {

	private String productId;
	private String productName;
	private String productDesc;
	private int quantity;
	
	public Product() {
		//default constructor
	}
	public Product(String productId, String productName, String productDesc, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", quantity=" + quantity + "]";
	}
}
