package com.inventory.bo;

/**
 * This class is used as Business object for Order Information
 * 
 *
 */
public class Order {

	public Order() {
		// default constructor
	}
	
	public Order(String orderId, String productId, int quantity, String status) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}

	private String orderId;
	private String productId;
	private int quantity;
	private String status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", status="
				+ status + "]";
	}
	
}
