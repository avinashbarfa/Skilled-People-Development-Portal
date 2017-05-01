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
		double clongitude = 0;
		double clatitude = 0;
		String nameOfCompany = request.getParameter("cname");
		String skill = request.getParameter("skill-wise");
		// System.out.println(nameOfCompany);
		int numberOfPeople = Integer.parseInt(request.getParameter("nop"));
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn
					.prepareStatement("SELECT compname,latitude,longitude from company where compname=?");
			ps.setString(1, nameOfCompany);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clongitude = Double.parseDouble(rs.getString("longitude")); // 77.5946;
				clatitude = Double.parseDouble(rs.getString("latitude")); // 12.9716;
			}

			al = locator(clongitude, clatitude, numberOfPeople, skill);
			// int count = 1;
			out.println("<body style='background-color:transparent;'>");
			out.print("<h1 style='text-align: center;color: darkcyan;padding-top:12px;'>* Labour Details *</h1>");
			out.print(
					"<table style='margin-left: 380px;margin-top: 58px;background-color: rgba(0, 150, 136, 0.66);padding: 18px;width:1150px;border-spacing: 0;border: 1px solid #ddd;'");
			out.print("<tr>");
			out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Full Name</h5></td>");
			out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Skill</h5></td>");
			out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Contact Number</h5></td>");
			out.print("</tr>");
			Iterator<String> it = al.iterator();
			while (it.hasNext()) {
				String[] splited = it.next().split("\\s+");
				out.print("<tr><td style='border: none;text-align: left;padding: 8px;'>" + splited[0] + " " + splited[1]
						+ "</td><td>" + splited[2] + " </td><td>" + splited[3] + "</td></tr>");
			}
			out.print("</tr>");
			out.print("</table>");
			out.print(
					"<h4 style='text-align: center;margin-top: 24px;'><a style='text-decoration: none;' href='employerdashboard.jsp'>Go Back to the Dashbaord</a>");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	String query(double clongitude, double clatitude, int dist) {

		double latitudeDist = clatitude * 111194.9266;
		double longitudeDist = clongitude * 111194.9266;
		double minLatitudeDist = latitudeDist - dist;
		String minLatitude = String.valueOf(minLatitudeDist / 111194.9266);
		double minLongitudeDist = longitudeDist - dist;
		String minLongitude = String.valueOf(minLongitudeDist / 111194.9266);
		double maxLatitudeDist = latitudeDist + dist;
		String maxLatitude = String.valueOf(maxLatitudeDist / 111194.9266);
		double maxLongitudeDist = longitudeDist + dist;
		String maxLongitude = String.valueOf(maxLongitudeDist / 111194.9266);
		String query = "SELECT id,fullname,skill,contact,latitude,longitude from labour WHERE longitude <= "
				+ maxLongitude + " and longitude >= " + minLongitude + " and latitude <= " + maxLatitude
				+ " and latitude >= " + minLatitude + " and jobstatus = ? and skill = ?";
		return query;
	}

	ArrayList<String> locator(double clongitude, double clatitude, int numberOfPeople, String skill) {

		ArrayList<String> al = new ArrayList<>();

		int dist = 70;// Hundred Kilometers radius.

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");

			int count = 0;

			while (count <= numberOfPeople) {

				count = 0;

				PreparedStatement ps1 = conn.prepareStatement(query(clongitude, clatitude, dist));
				ps1.setString(1, "Not Employed");
				ps1.setString(2, skill);
				ResultSet rs1 = ps1.executeQuery();

				while (rs1.next()) {
					count++;
				}

				if (count <= numberOfPeople) {
					dist += 70;
				}

			}

			PreparedStatement ps2 = conn.prepareStatement(query(clongitude, clatitude, dist));
			ps2.setString(1, "Not Employed");
			ps2.setString(2, skill);
			ResultSet rs2 = ps2.executeQuery();

			int count2 = 0;

			while (rs2.next()) {

				String name = rs2.getString(2);
				String contact = rs2.getString(4);
				String skilled = rs2.getString(3);
				String concat = name + " " + skilled + " " + contact;
				al.add(concat);
				count2++;

				if (count2 == numberOfPeople) {
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return al;
	}
}