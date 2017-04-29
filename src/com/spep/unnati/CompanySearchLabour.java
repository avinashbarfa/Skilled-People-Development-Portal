package com.spep.unnati;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNearestLocations
 */
@WebServlet("/CompanySearchLabour")
public class CompanySearchLabour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanySearchLabour() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		double clongitude = 0, clatitude = 0;
		// String state = "";
		// String name = request.getParameter("name");
		// System.out.println(name);
		// String number = request.getParameter("number");
		// System.out.println(number);
		ArrayList<String> al = new ArrayList<>();
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati",
			// "root", "root");
			// PreparedStatement ps = conn
			// .prepareStatement("SELECT compname,latitude,longitude,state from
			// company where compname=?");
			// ps.setString(1, name);
			// ResultSet rs = ps.executeQuery();
			// int numberofPeople = 0;
			/*
			 * if (rs.next()) { clongitude =
			 * Double.parseDouble(rs.getString("longitude")); clatitude =
			 * Double.parseDouble(rs.getString("latitude")); state =
			 * rs.getString(6); }
			 */
			al = locator();
			Iterator<String> it = al.iterator();
			while (it.hasNext()) {
				out.println("<center>");
				out.println("<br><br>");
				out.println(it.next() + "<br><br>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	ArrayList<String> locator() {

		ArrayList<String> al = new ArrayList<>();
		// clongitude = 78;
		// clatitude = 18;
		// numberOfPeople = 20;
		// int get = 0;
		// double latitudeDist = clatitude * 111194.9266;
		// double longitudeDist = clongitude * 111194.9266;
		int dist = 500;
		// Boolean flag = false;

		// while (al.size() < numberOfPeople) {
		// double minLatitudeDist = latitudeDist - dist;
		// String minLatitude = String.valueOf(minLatitudeDist / 111194.9266);
		// double minLongitudeDist = longitudeDist - dist;
		// String minLongitude = String.valueOf(minLongitudeDist / 111194.9266);
		// double maxLatitudeDist = latitudeDist + dist;
		// String maxLatitude = String.valueOf(maxLatitudeDist / 111194.9266);
		// double maxLongitudeDist = longitudeDist + dist;
		// String maxLongitude = String.valueOf(maxLongitudeDist / 111194.9266);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			// PreparedStatement ps1 = conn.prepareStatement("SELECT
			// id,jobstatus,latitude,longitude from labour WHERE "
			// + "latitude >= ? and latitude <= ? and longitude >= ? and
			// longitude <= ?");
			PreparedStatement ps1 = conn.prepareStatement(
					"SELECT id,fullname,contact,latitude,longitude from labour WHERE longitude <= 80 and longitude >= 76 and latitude <= 9 and latitude >= 8.4");
			// ps1.setString(1, "Not Employed");
			// ps1.setString(2, minLatitude);
			// ps1.setString(3, maxLatitude);
			// ps1.setString(4, minLongitude);
			// ps1.setString(5, maxLongitude);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				String name = rs1.getString(2);
				String contact = rs1.getString(3);
				String concat = name + " " + contact;
				al.add(concat);
				/*
				 * double latitude = 0; double longitude = 0; int id = 0;
				 * latitude = Double.parseDouble(rs1.getString(10)); longitude =
				 * Double.parseDouble(rs1.getString(11)); id =
				 * Integer.parseInt(rs1.getString(1));
				 * 
				 * if (latitude <= latitudeDist + dist && latitude >=
				 * latitudeDist - dist) { if (longitude <= latitudeDist + dist
				 * && longitude >= latitudeDist - dist) { al.add(id); if
				 * (al.size() >= numberOfPeople) { flag = true; break; } } } if
				 * (flag) { break; }
				 * 
				 * dist += 500;
				 */
			}

			dist += 500;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
		return al;
	}
}