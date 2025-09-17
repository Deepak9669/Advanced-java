package com.rays.jdbc;

import java.sql.*;

public class TestCollection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
//		load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Make connection to the database
		Connection coon=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
		
//		create statement
		Statement stmt=coon.createStatement();
		
//		Exceute query to set ResultSet
		ResultSet rs=stmt.executeQuery("select * from marksheet");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print(" t "+rs.getInt(2));
			System.out.print(" t "+rs.getString(3));
			System.out.print(" t "+rs.getInt(4));
			System.out.print(" t "+rs.getInt(5));
			System.out.print(" t "+rs.getInt(6));
			System.out.print(" t "+rs.getInt(7));
			System.out.println(rs.getInt(8));

		}
		rs.close();
	}		
}	
		
		

		
		
		
		
		