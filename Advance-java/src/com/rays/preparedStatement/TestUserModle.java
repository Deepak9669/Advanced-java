package com.rays.jdbc.preparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModle {
	public static void main(String[] args) throws Exception {
		testAdd();

	}
	public static void testAdd() throws ParseException, ClassNotFoundException, SQLException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		
		bean.setId(4);
		bean.setFirstName("Deepak");
		bean.setLastName("verma");
		bean.setLogin("deepak@gmail.com123");
		bean.setPassword("dev123");		
		bean.setDob(sdf.parse("2002-06-01"));
		
		model.add(bean);
	}

}
