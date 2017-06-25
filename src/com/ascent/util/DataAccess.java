package com.ascent.util;

import java.sql.Connection;

import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DataAccess {

	private static String url = "jdbc:mysql://localhost:3306/ascentweb";
	private static String user = "root"; 
	private static String password = "admin";
	
	public static Connection getConnection() {
		Connection con = null; 
		try {
			/** create the data source that can generate PooledConnection */
			MysqlConnectionPoolDataSource pooledDS = new MysqlConnectionPoolDataSource();
			pooledDS.setUrl(url);
			pooledDS.setUser(user);
			pooledDS.setPassword(password);
			
			/** create PooledConnection using pooled data source, which represents the physical connection of data source  */
			PooledConnection pooledConn = pooledDS.getPooledConnection();
			con = pooledConn.getConnection();
			
			con.setAutoCommit(false);
			
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return con;
	}
}
