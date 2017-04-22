package com.spep.unnati;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLabour
 */
@WebServlet("/AddLabour")
public class AddLabour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLabour() {
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
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String zip = request.getParameter("zip");
		String gender = request.getParameter("gender");
		String skill = request.getParameter("skill");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String latitude = request.getParameter("latitude");
		String longitutde = request.getParameter("longitude");
		String status = "Not Employed";
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO labour (fullname,contact,gender,skill,country,state,zip,city,latitude,longitude,jobstatus) Values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setString(3, gender);
			ps.setString(4, skill);
			ps.setString(5, country);
			ps.setString(6, state);
			ps.setString(7, zip);
			ps.setString(8, city);
			ps.setString(9, latitude);
			ps.setString(10, longitutde);
			ps.setString(11, status);

			int i = ps.executeUpdate();

			if (i > 0) {
				out.println("Labour Is Successfully Registered !");
				RequestDispatcher rd = request.getRequestDispatcher("successlaboursignup.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			System.out.print(ex);
		}

	}

}
