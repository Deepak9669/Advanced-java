package com.rays.jdbc.bank;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testUserModel {
	public static void main(String[] args) throws Exception {
		testAdd();
	}
	public static void testAdd() throws ParseException, ClassNotFoundException, SQLException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model= new UserModel();
		UserBean bean = new UserBean();
		
		System.out.println(model.nextpk());
		
		bean.setId(4);
		bean.setName("sonu");
		bean.setBank("CBI");
		bean.setAccountNo("1234532");
		bean.setAccountType("current");
		bean.setDob(sdf.parse("2003-04-26"));
		
		model.add(bean);
	}

}
