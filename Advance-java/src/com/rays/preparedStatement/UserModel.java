package com.rays.jdbc.preparedStatement;

import java.sql.*;
import java.text.SimpleDateFormat;


public class UserModel {
	
	public int nextpk() throws ClassNotFoundException, SQLException {
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		PreparedStatement ptmt=conn.prepareStatement("select max(id)from st_user");
		
		ResultSet rs=ptmt.executeQuery();
		
		while(rs.next()) {
			pk=rs.getInt(1);
			
		}
		conn.close();
		return pk +1;
	}
	public void add(UserBean bean) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
	PreparedStatement psmt=	conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
	
	     int pk=nextpk(); 
	     
	     psmt.setInt(1, pk);
	     psmt.setString(2, bean.getFirstName());
	     psmt.setString(3, bean.getLastName());
	     psmt.setString(4, bean.getLogin());
	     psmt.setString(5, bean.getPassword());
	     psmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
	
	int i =	psmt.executeUpdate();
	System.out.println("insert data sucessfully :"+i);
	
	conn.close();
		
	}

}
