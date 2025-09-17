package com.rays.jdbc;

import java.sql.*;

public class TestUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		load class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		make conection to database
		Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
				
//				create statement
				Statement stmt=coon.createStatement();
		
//		execute querey to set resultset
		int i = stmt.executeUpdate("update marksheet set id=16 where rollNo=1234526");
		
		coon.close();
	}

}
