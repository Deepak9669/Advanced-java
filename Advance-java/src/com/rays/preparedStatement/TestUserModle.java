package com.rays.jdbc.preparedStatement;

import java.sql.SQLException;

public class TestUserModle {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserModel model=new UserModel();
		System.out.println(model.nextpk());
	}

}
