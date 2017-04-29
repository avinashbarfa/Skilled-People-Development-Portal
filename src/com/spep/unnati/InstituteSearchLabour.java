package com.spep.unnati;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InstituteSearchLabour
 */
@WebServlet("/InstituteSearchLabour")
public class InstituteSearchLabour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstituteSearchLabour() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("search-as");
		String innerskill = request.getParameter("skill-wise");
		String innerstate = request.getParameter("state-wise");
		String label2 = "null";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			if (option.equalsIgnoreCase("skill")) {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
				PreparedStatement ps = conn.prepareStatement("select * from labour where skill=?");

				if (innerskill.equalsIgnoreCase("Tailor")) {

					label2 = "Tailor";
				} else if (innerskill.equalsIgnoreCase("Agriculture")) {
					label2 = "Agriculture";
				} else if (innerskill.equalsIgnoreCase("Nursing")) {
					label2 = "Nursing";
				} else if (innerskill.equalsIgnoreCase("Fabrication")) {
					label2 = "Fabrication";
				} else if (innerskill.equalsIgnoreCase("Electrician")) {
					label2 = "Electrician";
				} else if (innerskill.equalsIgnoreCase("Teacher")) {
					label2 = "Teacher";
				} else {
					out.println("<h2>Error Ocurrened While Searching. Contact The Team</p>");
				}
				ps.setString(1, label2);

				out.println("<body style='background-color:transparent;'>");
				out.print("<h1 style='text-align: center;color: darkcyan;padding-top:12px;'>* Labour Details *</h1>");

				/* Printing column names */
				ResultSet rs = ps.executeQuery();
				// ResultSetMetaData rsmd = rs.getMetaData();

				out.print(
						"<table style='margin-left: 100px;margin-top: 58px;background-color: rgba(0, 150, 136, 0.66);padding: 18px;width:1150px;border-spacing: 0;border: 1px solid #ddd;'");
				// int total = rsmd.getColumnCount();
				out.print("<tr>");

				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Full Name</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Contact Number</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Gender</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Skill Knows</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Country</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>State</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Pin Code</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>City</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Job Status</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>EmployedIn</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Date Of Registration</h5></td>");

				out.print("</tr>");

				/* Printing result */
				out.println("</br>");
				while (rs.next()) {
					out.print("<tr><td style='border: none;text-align: left;padding: 8px;'>" + rs.getString(2)
							+ "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>"
							+ rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7)
							+ "</td><td>" + rs.getString(8) + "</td><td>" + rs.getString(9) + "</td><td>"
							+ rs.getString(12) + "</td><td>" + rs.getString(13) + "</td><td>" + rs.getString(14)
							+ "</td></tr>");

				}

				out.print("</tr>");
				out.print("</table>");
			} else if (option.equalsIgnoreCase("state")) {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
				PreparedStatement ps = conn.prepareStatement("select * from labour where state=?");

				if (innerstate.equalsIgnoreCase("Andra Pradesh")) {

					label2 = "Andra Pradesh";
				} else if (innerstate.equalsIgnoreCase("Arunachal Pradesh")) {
					label2 = "Arunachal Pradesh";
				} else if (innerstate.equalsIgnoreCase("Assam")) {
					label2 = "Assam";
				} else if (innerstate.equalsIgnoreCase("Bihar")) {
					label2 = "Bihar";
				} else if (innerstate.equalsIgnoreCase("Chhattisgarh")) {
					label2 = "Chhattisgarh";
				} else if (innerstate.equalsIgnoreCase("Goa")) {
					label2 = "Goa";
				} else if (innerstate.equalsIgnoreCase("Gujarat")) {
					label2 = "Gujarat";
				} else if (innerstate.equalsIgnoreCase("Haryana")) {
					label2 = "Haryana";
				} else if (innerstate.equalsIgnoreCase("Himachal Pradesh")) {
					label2 = "Himachal Pradesh";
				} else if (innerstate.equalsIgnoreCase("Jammu and Kashmir")) {
					label2 = "Jammu and Kashmir";
				} else if (innerstate.equalsIgnoreCase("Jharkhand")) {
					label2 = "Jharkhand";
				} else if (innerstate.equalsIgnoreCase("Karnataka")) {
					label2 = "Karnataka";
				} else if (innerstate.equalsIgnoreCase("Kerala")) {
					label2 = "Kerala";
				} else if (innerstate.equalsIgnoreCase("Madhya Pradesh")) {
					label2 = "Madhya Pradesh";
				} else if (innerstate.equalsIgnoreCase("Maharashtra")) {
					label2 = "Maharashtra";
				} else if (innerstate.equalsIgnoreCase("Manipur")) {
					label2 = "Manipur";
				} else if (innerstate.equalsIgnoreCase("Meghalaya")) {
					label2 = "Meghalaya";
				} else if (innerstate.equalsIgnoreCase("Mizoram")) {
					label2 = "Mizoram";
				} else if (innerstate.equalsIgnoreCase("Nagaland")) {
					label2 = "Nagaland";
				} else if (innerstate.equalsIgnoreCase("Odisha")) {
					label2 = "Odisha";
				} else if (innerstate.equalsIgnoreCase("Punjab")) {
					label2 = "Punjab";
				} else if (innerstate.equalsIgnoreCase("Rajasthan")) {
					label2 = "Rajasthan";
				} else if (innerstate.equalsIgnoreCase("Sikkim")) {
					label2 = "Sikkim";
				} else if (innerstate.equalsIgnoreCase("Tamil Nadu")) {
					label2 = "Tamil Nadu";
				} else if (innerstate.equalsIgnoreCase("Telangana")) {
					label2 = "Telangana";
				} else if (innerstate.equalsIgnoreCase("Tripura")) {
					label2 = "Tripura";
				} else if (innerstate.equalsIgnoreCase("Uttar Pradesh")) {
					label2 = "Uttar Pradesh";
				} else if (innerstate.equalsIgnoreCase("Uttarakhand")) {
					label2 = "Uttarakhand";
				} else if (innerstate.equalsIgnoreCase("West Bengal")) {
					label2 = "West Bengal";
				} else {
					out.println("<h2>Error Ocurrened While Searching. Contact The Team</p>");
				}
				ps.setString(1, label2);

				out.println("<body style='background-color:transparent;'>");
				out.print("<h1 style='text-align: center;color: darkcyan;padding-top:12px;'>* Labour Details *</h1>");

				/* Printing column names */
				ResultSet rs = ps.executeQuery();
				// ResultSetMetaData rsmd = rs.getMetaData();

				out.print(
						"<table style='margin-left: 100px;margin-top: 58px;background-color: rgba(0, 150, 136, 0.66);padding: 18px;width:1150px;border-spacing: 0;border: 1px solid #ddd;'");
				// int total = rsmd.getColumnCount();
				out.print("<tr>");

				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Full Name</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Contact Number</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Gender</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Skill Knows</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Country</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>State</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Pin Code</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>City</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Job Status</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>EmployedIn</h5></td>");
				out.print("<td style='border: none;text-align: left;padding: 8px;'><h5>Date Of Registration</h5></td>");

				out.print("</tr>");

				/* Printing result */
				out.println("</br>");
				while (rs.next()) {
					out.print("<tr><td style='border: none;text-align: left;padding: 8px;'>" + rs.getString(2)
							+ "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>"
							+ rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7)
							+ "</td><td>" + rs.getString(8) + "</td><td>" + rs.getString(9) + "</td><td>"
							+ rs.getString(12) + "</td><td>" + rs.getString(13) + "</td><td>" + rs.getString(14)
							+ "</td></tr>");

				}

				out.print("</tr>");
				out.print("</table>");
			} else if (option.equalsIgnoreCase("username")) {
				/* Printing result */
				String label = request.getParameter("searchlabel");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
				PreparedStatement ps = conn.prepareStatement("select * from labour where fullname=?");
				ps.setString(1, label);

				out.println("<body style='background-color:transparent;'>");
				out.print("<h1 style='text-align: center;color: darkcyan;padding-top:12px;'>* Labour Details *</h1>");

				ResultSet rs = ps.executeQuery();
				out.print(
						"<table style='margin-left: 300px;margin-top: 58px;background-color: rgba(0, 150, 136, 0.66);padding: 18px;width:800px;'>");

				while (rs.next()) {
					out.print("<tr>");
					out.print("<td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Sr. No" + "</td>");
					out.print("<td>" + rs.getString(1) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Full Name :" + "</td>");
					out.print("<td>" + rs.getString(2) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Contact Number :" + "</td>");
					out.print("<td>" + rs.getString(3) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Gender :" + "</td>");
					out.print("<td>" + rs.getString(4) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Skill Knows :" + "</td>");
					out.print("<td>" + rs.getString(5) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Country :" + "</td>");
					out.print("<td>" + rs.getString(6) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "State :" + "</td>");
					out.print("<td>" + rs.getString(7) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Pin Code :" + "</td>");
					out.print("<td>" + rs.getString(8) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "City :" + "</td>");
					out.print("<td>" + rs.getString(9) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Job Status : " + "</td>");
					out.print("<td>" + rs.getString(12) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "EmployedIn :" + "</td>");
					out.print("<td>" + rs.getString(13) + "</td></tr>");
					out.print("<tr><td style='padding: 6px 0px;font-size: 16px;color: cornsilk;font-family: serif;'>"
							+ "Date Of Registration :" + "</td>");
					out.print("<td>" + rs.getString(13) + "</td></tr>");
				}

				out.print("</table>");
			} else {
				out.println("Error in Searching");
			}
			out.print(
					"<h4 style='text-align: center;margin-top: 24px;'><a style='text-decoration: none;' href='institutedashboard.jsp'>Go Back to the Dashbaord</a>");

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		finally {
			out.close();

		}
	}

}