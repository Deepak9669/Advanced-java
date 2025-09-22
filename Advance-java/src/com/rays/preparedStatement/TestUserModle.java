package com.rays.jdbc.preparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModle {
	public static void main(String[] args) throws Exception {
//		 testFindByLogin();
//     	 testAdd();
//	     testUpdate();
//		 testDelete();
//		testAutenticate();
//		testChangePassword();
		testSearch();		
	}
	public static void testAdd() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		
		System.out.println(model.nextpk());
		
		bean.setId(5);
		bean.setFirstName("sumit");
		bean.setLastName("verma");
		bean.setLogin("sumit@gmail.com123");
		bean.setPassword("dev123");		
		bean.setDob(sdf.parse("2000-06-01"));
		
		model.add(bean);
	}
//	test delete record
	
	public static void testDelete() throws ClassNotFoundException, SQLException {
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		
		System.out.println(model.nextpk());
		
		bean.setId(12);
		
		model.delete(bean);
		
		
	}
//	test update records
	
	public static void testUpdate() throws ClassNotFoundException, SQLException, ParseException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		System.out.println(model.nextpk());
		
		bean.setId(3);
		bean.setFirstName("devraj");
		bean.setLastName("pandit ji");
		bean.setLogin("devil@1234");
		bean.setPassword("1235");
		bean.setDob(sdf.parse("2004-06-18"));
		
		model.update(bean);
	}
	public static void testFindByLogin() throws Exception {
		
		UserModel model = new UserModel();
		System.out.println(model.nextpk());

		
		UserBean existsBean = model.findByLogin("ram@gmail.com");
		
		if(existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");

		
		
		}
	}
	public static void testAutenticate() throws Exception {
		
		UserModel model = new UserModel();
//		System.out.println(model.nextpk());

		
		UserBean existsBean = model.autenticate("ram@gmail.com" ,"ram123");
		
		if(existsBean != null) {
			System.out.println("login sucesfull");
		} else {
			System.out.println("Wrong password and user name");

		
		
		}
	}
	public static void testChangePassword() throws ClassNotFoundException, SQLException {
		UserModel  model = new UserModel ();
		model.changePassword("ram@gmail.com","ram123","123457");
	}
	
	public static void testSearch() throws Exception {
		
		UserModel model=new UserModel();
		
		UserBean bean = new UserBean();
//		bean.setFirstName("devil");
//		bean.setLastName("verma");
//		bean.setLogin("devil@123");
//		bean.setPassword("dev@123");
		bean.setId(2);
		
		List list= model.search(bean);
		
     Iterator<UserBean>	it=	list.iterator();
     
     while(it.hasNext()) {
    	 
      bean= it.next();
     
     System.out.print(bean.getId());
     System.out.print( "\t"+bean.getFirstName());
     System.out.print("\t"+bean.getLastName());
     System.out.print("\t"+bean.getLogin());
     System.out.print("\t"+bean.getPassword());
     System.out.println("\t"+bean.getDob());
     
    	 
     }
		
		
	}


	}


