package com.spep.unnati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignupValidate {

	public static int eValidate(String organization, String password, String contact, String country, String state,
			String zip, String city, String latitude, String longitude) {

		int i = 0;
		password = HashPassword.hashed(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO company (compname,userpass,contact,country,state,zip,city,latitude,longitude) VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, password);
			ps.setString(3, contact);
			ps.setString(4, country);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, city);
			ps.setString(8, latitude);
			ps.setString(9, longitude);
			i = ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}

	public static int tValidate(String organization, String password, String contact, String country, String state,
			String zip, String city, String latitude, String longitude) {

		int i = 0;
		password = HashPassword.hashed(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO institute (instiname,userpass,contact,country,state,zip,city,latitude,longitude) VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, password);
			ps.setString(3, contact);
			ps.setString(4, country);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, city);
			ps.setString(8, latitude);
			ps.setString(9, longitude);
			i = ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}
}
