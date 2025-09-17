package com.rays.jdbc;
import java.sql.*;

public class TestDelet {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Make connection to database
		Connection coon=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
		
//		create Statenment
		Statement stmt=coon.createStatement();
		
//		execute qurey to set resultSet
		int  i =stmt.executeUpdate("delete from marksheet where rollNo=1234525");
		
		coon.close();
				
	}

}
