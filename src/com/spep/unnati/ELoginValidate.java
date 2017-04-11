package com.spep.unnati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ELoginValidate {

	private static boolean status = false;

	public static boolean validate(String uname, String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root",
					"root");
			PreparedStatement ps = conn
					.prepareStatement("SELECT compname,userpass FROM company WHERE compname=? and userpass=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
}
