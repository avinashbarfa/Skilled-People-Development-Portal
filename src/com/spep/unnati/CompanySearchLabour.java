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
		int count = 0;
		PrintWriter out = response.getWriter();
		double longitude = 0, latitude = 0;
		String state = request.getParameter("state");
		String number = request.getParameter("number");
		ArrayList<String> al = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement("SELECT state,latitude,longitude from company where state=?");
			PreparedStatement ps1 = conn
					.prepareStatement("SELECT fullname,state,latitude,longitude from labour where state=?");
			ps.setString(1, state);
			ps1.setString(1, state);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			int numberofPeople = Integer.parseInt(number);
			out.println(rs.next());
			if (rs.next()) {
				longitude = Double.parseDouble(rs.getString("longitude"));
				latitude = Double.parseDouble(rs.getString("latitude"));
			}
			while (rs1.next()) {
				count++; // Contains the total no. of labours in that state
			}
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				double llongitude = Double.parseDouble(rs1.getString("longitude"));
				double llatitude = Double.parseDouble(rs1.getString("latitude"));
				al = locator(numberofPeople, count, longitude, latitude, llatitude, llongitude,
						rs1.getString("fullname"));
			}

			Iterator<String> it = al.iterator();
			while (it.hasNext()) {
				out.println(it.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	ArrayList<String> locator(int numberOfPeople, int count, double longitude, double latitude, double llatitude,
			double llongitude, String name) {

		ArrayList<String> al = new ArrayList<String>();
		int get = 0;
		double latitudeDist = latitude * 111194.9266;
		double longitudeDist = longitude * 111194.9266;
		int dist = 500;
		Boolean flag = false;

		while (al.size() < numberOfPeople) {
			while (count != 0) {
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
				count--;
			}
		}
		return al;
	}
}