package com.spep.unnati;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		int count = 0;
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
		ArrayList<String> al = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement("SELECT city,latitude,longitude from company where city=?");
			PreparedStatement ps1 = conn.prepareStatement("SELECT name,latitude,longitude from labour where city=?");
			ps.setString(0, city);
			ps1.setString(0, city);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			double longitude = Double.parseDouble(rs.getString("longitude"));
			double latitude = Double.parseDouble(rs.getString("latitude"));
			double llongitude = Double.parseDouble(rs1.getString("longitude"));
			double llatitude = Double.parseDouble(rs1.getString("latitude"));
			while (rs1.next()) {
				count++;
			}
			al = locator(count, longitude, latitude, llatitude, llongitude, rs.getString("fullname"));

			out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	ArrayList<String> locator(int numberOfPeople, double longitude, double latitude,double llatitude,double llongitude,String name) {

		ArrayList<String> al = new ArrayList<String>();
		int get = 0;
		double latitudeDist = latitude * 111194.9266;
		double longitudeDist = longitude * 111194.9266;
		int dist = 500;
		Boolean flag = false;

		while (al.size() < numberOfPeople) {
			while () {
				if (llatitude <= latitudeDist + dist && llatitude >= latitudeDist - dist) {
					if (llongitude <= latitudeDist + dist && llongitude >= latitudeDist - dist) {
						al.add(name);
						if (al.size() >= numberOfPeople) {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					break;
				}

				dist += 500;
			}
			return al;
		}

	}
}