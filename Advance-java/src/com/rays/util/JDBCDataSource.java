package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public final class JDBCDataSource {
	
	private static JDBCDataSource datasourse=null;
	private static ComboPooledDataSource cpds=null;
	
	private JDBCDataSource() {
		
	}
	private static JDBCDataSource getInstance() {
		if(datasourse==null) {
			datasourse=new JDBCDataSource();
			datasourse.cpds=new ComboPooledDataSource();
			
			ResourceBundle rb=ResourceBundle.getBundle("com.rays.bundle.app");
			
			try {
				datasourse.cpds.setDriverClass(rb.getString("driver"));
				datasourse.cpds.setJdbcUrl(rb.getString("url"));
				datasourse.cpds.setUser(rb.getString("username"));
				datasourse.cpds.setPassword(rb.getString("password"));
				datasourse.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
				datasourse.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
				datasourse.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
				datasourse.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
		return datasourse;
	}
	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}
	
	public static void CloseConnection (Connection conn) throws SQLException {
		if(conn !=null) {
			conn.close();
			
		}
	}
		public static void trnRollback(Connection conn) throws SQLException {
			if(conn != null) {
				conn.rollback();
			}
		}
	}
	


