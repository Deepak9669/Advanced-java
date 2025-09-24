package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));
		System.out.println(rb1.getString("greeting"));
		
		ResourceBundle rb2 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("jp"));
		System.out.println(rb2.getString("greeting"));
		
		ResourceBundle rb3 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("fr"));
		System.out.println(rb3.getString("greeting"));



		
	}

}
