package com.rays.jdbc.bank;

import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;


public class UserModel {
	   public int nextpk() throws ClassNotFoundException, SQLException {
		   
		   int pk=0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		PreparedStatement psmt=conn.prepareStatement("select max(id) from bank");
		
		ResultSet rs= psmt.executeQuery();
		
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		
		
		conn.close();
		
		return pk +1;
		
	   }
	   public void add(UserBean bean) throws ClassNotFoundException, SQLException {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		   
		   PreparedStatement psmt=conn.prepareStatement("insert into bank values(?,?,?,?,?,?)");
		   
		   int pk=nextpk();
		   
		   psmt.setInt(1, pk);
		   psmt.setString(2, bean.getName());
		   psmt.setString(3, bean.getBank());
		   psmt.setString(4, bean.getAccountNo());
		   psmt.setString(5, bean.getAccountType());
		   psmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		   
		   int i = psmt.executeUpdate();
		   
		   System.out.println("insert data sucessfully :"+i);
		   
		   conn.close();
		   
	   }
	   public void delete(UserBean bean) {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		   
		   PreparedStatement psmt=conn.prepareStatement("select * from st_user where id=?");

		   

		   
		   
		   }
		   
		   
		   
	   }
	


