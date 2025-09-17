package com.rays.jdbc;

import java.sql.*;

public class TestInherit {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		make connection database
		Connection coon=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
//		create Statemenr 
		Statement stmt=coon.createStatement();
		
//		Execute Querey to set resultSet
		int i =stmt.executeUpdate("insert into marksheet values(15,1234526,'devil',55,65,56,75,56)");
		
		System.out.println("Data insert sucessfully"+" "+i);
		
		coon.close();
	}

}
