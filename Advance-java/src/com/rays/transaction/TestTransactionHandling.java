package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		
	    Connection conn=null;
	    
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
     	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
     	
     	conn.setAutoCommit(false);
     	
     	Statement stmt=conn.createStatement();
     	
     	int i = stmt.executeUpdate("insert into employee values(17,'rohit','TCS',67909,5,'Indore')");
     	 i = stmt.executeUpdate("insert into employee values(17,'rohit','TCS'."
     	 		+ "67909,5,'Indore')");
     	i = stmt.executeUpdate("insert into employee values(18,'rohit','TCS'.67909,5,'Indore')");
     	
			conn.commit();
     	
     	System.out.println("transaction is commited");
	    }catch(Exception e) {
			conn.rollback();
		System.out.println("transaction is roll back");
			
		}
		
}
	}


