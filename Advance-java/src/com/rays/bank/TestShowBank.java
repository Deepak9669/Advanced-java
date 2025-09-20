package com.rays.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestShowBank {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt=conn.createStatement();
		
	   ResultSet rs=stmt.executeQuery("select * from bank");
	   
	   while(rs.next()) {
		   System.out.print(rs.getInt(1));
		   System.out.print("\t"+rs.getString(2));
		   System.out.print("\t"+rs.getString(3));
		   System.out.print("\t"+rs.getString(4));
		   System.out.print("\t"+rs.getString(5));
		   System.out.println("\t"+rs.getDate(6));
		   
		   
	   }
	   conn.close();
	}

}
