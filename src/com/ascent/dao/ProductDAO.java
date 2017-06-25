package com.ascent.dao;

import java.sql.*;
import java.util.*;
import com.ascent.bean.Product;
import com.ascent.util.DataAccess;

public class ProductDAO {

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		Connection con = DataAccess.getConnection();
		String sql = "select * from product p order by p.id"; 
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product pu = new Product();
				pu.setId(rs.getInt("id"));
				pu.setProductnumber(rs.getString("productnumber"));
				pu.setProductname(rs.getString("productname"));
				pu.setCategoryno(rs.getString("categoryno"));
				pu.setCategory(rs.getString("category"));
				pu.setImagePath(rs.getString("imagePath"));
				pu.setIsnewproduct(rs.getString("isnewproduct"));
				pu.setPrice(rs.getFloat("price"));
				pu.setVipprice(rs.getFloat("vipprice"));
				pu.setStock(rs.getString("stock"));
				pu.setRealstock(rs.getString("realstock"));
				pu.setDescription(rs.getString("description"));
				pu.setWeight(rs.getString("weight"));
				
				list.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} 
				if (stmt != null) {
					stmt.close();
				} 
				if (con != null) {
					con.close();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
