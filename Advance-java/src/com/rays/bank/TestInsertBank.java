package com.rays.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertBank {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt=conn.createStatement();
		
		int i = stmt.executeUpdate("insert into bank values(3,'mohit','SBI','1234513','Saving','2003-06-01')");
		
		System.out.println(i);
		
		conn.close();
	}

}
