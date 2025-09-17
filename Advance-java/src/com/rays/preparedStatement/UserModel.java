package com.rays.jdbc.preparedStatement;

import java.sql.*;


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

}
