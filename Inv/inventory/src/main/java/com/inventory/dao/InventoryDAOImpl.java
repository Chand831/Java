package com.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.inventory.bo.Dept;
import com.inventory.bo.InactiveProduct;
import com.inventory.bo.Order;
import com.inventory.bo.Product;

/**
 * This class is used for the implementation of the DAO layer.
 * 
 * 
 *
 */
public class InventoryDAOImpl {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Product getProductInfo(String productId) {

		String sql = "SELECT * FROM   PRODUCT " + "   WHERE PROD_ID = ? ";
		Connection conn = null;
		Product product = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getString("PROD_ID"), rs.getString("PROD_NAME"), rs.getString("PROD_DESC"),
						rs.getInt("PROD_QNTY"));
			}
			rs.close();
			ps.close();
			return product;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void insertProduct(Product product) {

		String sql = "INSERT INTO PRODUCT " + "(PROD_ID, PROD_NAME, PROD_DESC,PROD_QNTY) VALUES (?, ?, ?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductDesc());
			ps.setInt(4, product.getQuantity());
			ps.executeUpdate();
			ps.close();
			System.out.println(" Product "+product.toString()+" was  inserted ");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public String updateProduct(String productId, int prod_qnty) {

		String sql = "UPDATE  PRODUCT " + " SET PROD_QNTY = ?  WHERE PROD_ID = ? ";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, prod_qnty);
			ps.setString(2, productId);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return "success";
	}
	
	public Dept selectDeptInfo(Dept dept) {
		String sql = " SELECT *  FROM  DEPT  WHERE DEPT_ID = ? AND PROD_ID =  ? ";
		Connection conn = null;
		Dept existingDeptInfo = new Dept();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptId());
			ps.setString(2, dept.getProductId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				existingDeptInfo.setDeptId(rs.getString("DEPT_ID"));
				existingDeptInfo.setDeptName(rs.getString("DEPT_NAME"));
				existingDeptInfo.setDeptId(rs.getString("DEPT_DESC"));
				existingDeptInfo.setProductId(rs.getString("PROD_ID"));
				existingDeptInfo.setQuantity(rs.getInt("QNTY"));
			}
			rs.close();
			ps.close();
			System.out.println("Existing Dept info "+existingDeptInfo.toString());
			return existingDeptInfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	public void insertDept(Dept dept) {
		String sql = "INSERT INTO DEPT " + "(DEPT_ID, DEPT_NAME, DEPT_DESC,PROD_ID,QNTY) VALUES (?, ?, ?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptId());
			ps.setString(2, dept.getDeptName());
			ps.setString(3, dept.getDeptDesc());
			ps.setString(4, dept.getProductId());
			ps.setInt(5, dept.getQuantity());
			ps.executeUpdate();
			ps.close();
			System.out.println("Dept inserted " + dept.toString());
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public String updateDept(Dept dept) {
		String sql = " UPDATE  DEPT  " + " SET QNTY = ?  WHERE  DEPT_ID = ?  and PROD_ID = ?  ";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dept.getQuantity());
			ps.setString(2, dept.getProductId());
			ps.setString(3, dept.getDeptId());
			ps.executeUpdate();
			ps.close();
			System.out.println("Dept info updated "+dept.toString());
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return "Success";
	}


	public String insertIntoOrder_Inventory(Order order) {
		String sql = " INSERT INTO ORDER_INVENTORY " + "(ORDER_ID,  PROD_ID,QNTY,STATUS) VALUES (?, ?, ?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getProductId());
			ps.setInt(3, order.getQuantity());
			ps.setString(4, order.getStatus());
			ps.executeUpdate();
			ps.close();
			System.out.println("Order  "+order.toString()+" has been "+order.getStatus());
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	public void insertIntoInactive_Inventory(InactiveProduct inactiveProduct) {
		String sql = "INSERT INTO INACTIVE_INVENTORY " + "(ID,  PROD_ID, QNTY,REASON) VALUES (?, ?, ?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inactiveProduct.getId());
			ps.setString(2, inactiveProduct.getProductId());
			ps.setInt(3, inactiveProduct.getQuantity());
			ps.setString(4, inactiveProduct.getReason());
			ps.executeUpdate();
			ps.close();
			System.out.println("Product " + inactiveProduct.toString() + " inactivated ");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
