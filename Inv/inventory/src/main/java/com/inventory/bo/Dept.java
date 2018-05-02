package com.inventory.bo;
/**
 * This class is used as Business object for Dept Information
 * 
 *
 */
public class Dept {
	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Dept(String deptId, String deptName, String deptDesc, String productId, int quantity) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.productId = productId;
		this.quantity = quantity;
	}

	private String deptId;
	private String deptName;
	private String deptDesc;
	private String productId;
	private int quantity;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
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
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptDesc=" + deptDesc + ", productId="
				+ productId + ", quantity=" + quantity + "]";
	}

}
