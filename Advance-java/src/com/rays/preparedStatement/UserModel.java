package com.rays.jdbc.preparedStatement;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;


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
	public void add(UserBean bean) throws Exception {
		
		
	UserBean existsBean = findByLogin(bean.getLogin());	
//		UserBean existsBean=authenticate(bean.getPassword());      

            if (existsBean != null) {
				throw new Exception("login id already exist");

		}
		
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
	
	public void delete(UserBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
	PreparedStatement psmt=	conn.prepareStatement("delete from st_user where id=?");
	
	psmt.setInt(1, bean.getId());
	
	int i=psmt.executeUpdate();
	System.out.println("data delete sucessfully "+i);
	
	conn.close();
		
	}
	public void update(UserBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
	PreparedStatement psmt=	conn.prepareStatement("update st_user set firstName=?,lastName=?,login=?,password=?,dob=? where id=?");
          
	   psmt.setString(1, bean.getFirstName());
	   psmt.setString(2, bean.getLastName());
	   psmt.setString(3, bean.getLogin());
	   psmt.setString(4, bean.getPassword());
	   psmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
	   psmt.setInt(6, bean.getId());
	   
	   int i=psmt.executeUpdate();
	   System.out.println("data update sucesfully :"+i);
	   
	   conn.close();
		
	}
	public UserBean findByLogin(String login) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
	PreparedStatement psmt=	conn.prepareStatement("select * from st_user where login=?");
	
	  psmt.setString(1, login);
	  
	  ResultSet rs=psmt.executeQuery();
	  
	  UserBean bean=null;
	  
	  while(rs.next()) {
		  bean=new UserBean();
		  
      bean.setId(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setLogin(rs.getString(4));
      bean.setPassword(rs.getString(5));
      bean.setDob(rs.getDate(6));
		   

	}
	  return bean;

}
	    public UserBean autenticate(String login,String password) throws ClassNotFoundException, SQLException {
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
		PreparedStatement psmt=	conn.prepareStatement("select * from st_user where login=? and password=?");
		
		psmt.setString(1, login);
		psmt.setString(2, password);
		
		ResultSet rs=psmt.executeQuery();
          
		UserBean bean=null;
		
		while(rs.next()) {
			bean = new UserBean();
			
		      bean.setId(rs.getInt(1));
		      bean.setFirstName(rs.getNString(2));
		      bean.setLastName(rs.getNString(3));
		      bean.setLogin(rs.getNString(4));
		      bean.setPassword(rs.getString(5));
		      bean.setDob(rs.getDate(6));

			
		}
	    	return bean;
	    }
	    
	    public void changePassword(String login,String password,String newPassword) throws ClassNotFoundException, SQLException {
	    		    	
			
	    	UserBean bean = autenticate(login, password);
	    	if (bean!=null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				
				PreparedStatement psmt=conn.prepareStatement("Update st_user set password=? where id=?");
				
				psmt.setString(1, newPassword);
				psmt.setInt(2, bean.getId());
				
				psmt.executeUpdate();

	    		
				System.out.println("password change sucessfully");
			}else {
				throw new RuntimeException("wrong user name and password");
			}
	    }
	    public List search(UserBean bean)throws Exception  {
	    	List list = new ArrayList();
	    	
	    	StringBuffer sql=new StringBuffer("selectg * from st_user");
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			System.out.println("-------------------->"+sql.toString());
			
			PreparedStatement psmt=conn.prepareStatement(sql.toString());
			
			ResultSet rs=psmt.executeQuery();
			
			
			while(rs.next()) {
				 bean = new UserBean ();
				
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				
				list.add(bean);
			}
			return list;
	    	
	    	
	    }
	    
	
}
