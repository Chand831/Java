package com.inventory.bo;
/**
 * This class is used as Business object for InactiveProduct Information
 * 
 *
 */
public class InactiveProduct {

	public InactiveProduct(String id, String productId, int quantity, String reason) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.reason = reason;
	}

	public InactiveProduct() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String productId;
	private int quantity;
	private String reason;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "InactiveProduct [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", reason="
				+ reason + "]";
	}
	
}
