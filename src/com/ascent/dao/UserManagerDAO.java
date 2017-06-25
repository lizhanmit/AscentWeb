package com.ascent.dao;

import java.sql.*;
import java.util.*;

import com.ascent.bean.Usr;
import com.ascent.util.DataAccess;

public class UserManagerDAO {

	public List<Usr> getAllProductUser() {
		List<Usr> list = new ArrayList<Usr>();
		Connection con = DataAccess.getConnection();
		String sql = "select * from usr p order by p.id"; 
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Usr pu = new Usr();
				pu.setId(rs.getInt("id"));
				pu.setUsername(rs.getString("username"));
				pu.setPassword(rs.getString("password"));
				pu.setFullname(rs.getString("fullname"));
				pu.setTitle(rs.getString("title"));
				pu.setSuperuser(rs.getString("superuser"));
				
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
