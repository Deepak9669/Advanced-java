package com.rays.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdateBank {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt=conn.createStatement();
		
		int i=stmt.executeUpdate("update bank set bank='HDFC' where id=2");
		
		System.out.println("After bank update :"+i);
		
		
		conn.close();
		
	}

}
