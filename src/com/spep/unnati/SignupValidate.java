package com.spep.unnati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignupValidate {

	private static int i;

	public static int eValidate(String organization, String password, String contact, String country, String state,
			String zip, String city, String address) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO company (compname,userpass,contact,country,state,zip,city,address) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, password);
			ps.setString(3, contact);
			ps.setString(4, country);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, city);
			ps.setString(8, address);
			i = ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}

	public static int tValidate(String organization, String password, String contact, String country, String state,
			String zip, String city) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO company (compname,userpass,contact,country,state,zip,city) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, password);
			ps.setString(3, contact);
			ps.setString(4, country);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, city);
			i = ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}
}
