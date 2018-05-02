package com.inventory.inventoryImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inventory.bo.Dept;
import com.inventory.bo.InactiveProduct;
import com.inventory.bo.Order;
import com.inventory.bo.Product;
import com.inventory.dao.InventoryDAOImpl;

/**
 * This class is used for the service layer implementation of the Inventory management.
 * 
 */
public class InventoryImpl {

	private static InventoryDAOImpl inventoryDAO = null;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		inventoryDAO = (InventoryDAOImpl) context.getBean("inventoryDAO");
		InventoryImpl inventory = new InventoryImpl();
		inventory.updateProductInfo(inventory.getProduct(), "add");
		inventory.allocateProductForDept(inventory.getDepartmentInfo());
		inventory.orderProduct(inventory.getOrderInfo());
		inventory.inactivateProduct(inventory.getinactiveProduct());

	}

	/**
	 * This method is used to update the product information If
	 * productUpdateDetail param is "add" then product quantity will be
	 * increased. If productUpdateDetail param is "remove" then product quantity
	 * will be decreased.
	 * 
	 * @param product
	 * @param productUpdateDetail
	 * @return
	 */
	private String updateProductInfo(Product product, String productUpdateDetail) {
		String status = null;
		int availableQuantity = 0;
		Product existingProduct = inventoryDAO.getProductInfo(product.getProductId());
		if (existingProduct != null && product.getQuantity() >= 0) {
			availableQuantity = existingProduct.getQuantity();
			if ("add".equalsIgnoreCase(productUpdateDetail)) {
				status = inventoryDAO.updateProduct(product.getProductId(), availableQuantity + product.getQuantity());
			} else if ("remove".equalsIgnoreCase(productUpdateDetail)) {
				if (availableQuantity >= product.getQuantity()) {
					status = inventoryDAO.updateProduct(product.getProductId(),
							availableQuantity - product.getQuantity());
				} else {
					status = "Inventory doesn't have  that many products";
				}
			}
		} else if ("new".equalsIgnoreCase(productUpdateDetail)) {
			inventoryDAO.insertProduct(product);
		}
		System.out.println("Update product info Status :  " + status);
		return status;

	}

	/**
	 * This method If order status is received then verifies the order existence
	 * updates the product table and insert order info into Order table.
	 * Otherwise order info will be inserted into Order table
	 * 
	 * @param order
	 */
	private void orderProduct(Order order) {
		Product product = new Product();
		if ("RCV".equalsIgnoreCase(order.getStatus())) {
			product.setProductId(order.getProductId());
			product.setQuantity(order.getQuantity());
			updateProductInfo(product, "add");
			inventoryDAO.insertIntoOrder_Inventory(order);
		} else {
			inventoryDAO.insertIntoOrder_Inventory(order);
		}

	}

	/**
	 * This method is used to allocate product for the department.. Product
	 * quantity will be updated in the product table, dept table as per the
	 * request.
	 * 
	 * @param dept
	 */
	public void allocateProductForDept(Dept dept) {
		Dept existingDeptInfo = inventoryDAO.selectDeptInfo(dept);
		String updateProductInfoStatus = null;
		Product product = new Product();
		if (existingDeptInfo.getDeptId() != null) {
			product.setProductId(dept.getProductId());
			product.setQuantity(dept.getQuantity());
			existingDeptInfo.setQuantity(existingDeptInfo.getQuantity() + dept.getQuantity());
			updateProductInfoStatus = updateProductInfo(product, "remove");
			if (updateProductInfoStatus != null && updateProductInfoStatus.equals("success")) {
				inventoryDAO.updateDept(existingDeptInfo);
			}
		} else {
			product.setProductId(dept.getProductId());
			product.setQuantity(dept.getQuantity());
			updateProductInfoStatus = updateProductInfo(product, "remove");
			if (updateProductInfoStatus != null && updateProductInfoStatus.equals("success")) {
				inventoryDAO.insertDept(dept);
			}
		}
	}

	/**
	 * This method is used to inactive the product i.e. product quantity will be
	 * updated in the product table and inactive product quantity will also
	 * added into table.
	 * 
	 * @param inactiveProduct
	 */
	private void inactivateProduct(InactiveProduct inactiveProduct) {
		String productUpdated = null;
		Product product = new Product();
		product.setProductId(inactiveProduct.getProductId());
		product.setQuantity(inactiveProduct.getQuantity());
		productUpdated = updateProductInfo(product, "remove");
		if (productUpdated.equals("success")) {
			inventoryDAO.insertIntoInactive_Inventory(inactiveProduct);
		}
	}

	public Dept getDepartmentInfo() {
		Dept dept = new Dept();
		dept.setDeptId("1");
		dept.setDeptName("Science & technology");
		dept.setDeptDesc("Research on Science & Technology");
		dept.setProductId("3");
		dept.setQuantity(5);

		return dept;
	}

	public Product getProduct() {
		Product product = new Product();
		product.setProductId("3");
		product.setProductName("RAM");
		product.setQuantity(25);
		product.setProductDesc("Random Access memory device");
		return product;
	}

	public InactiveProduct getinactiveProduct() {
		InactiveProduct inactiveProduct = new InactiveProduct();
		inactiveProduct.setId("3");
		inactiveProduct.setProductId("3");
		inactiveProduct.setQuantity(1);
		inactiveProduct.setReason("Not needed as of now ");
		return inactiveProduct;
	}

	public Order getOrderInfo() {
		Order order = new Order();
		order.setOrderId("9");
		order.setProductId("3");
		order.setQuantity(12);
		order.setStatus("RCV");
		return order;
	}
}
