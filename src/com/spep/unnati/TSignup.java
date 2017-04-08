package com.spep.unnati;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ESignup
 */
@WebServlet("/TSignup")

public class TSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TSignup() {
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
		String organization = request.getParameter("firstname");
		String contact = request.getParameter("lastname");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://appuscorpion.me:3306/alognew", "root", "scorpion");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO company VALUES(?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, contact);
			ps.setString(3, zip);
			ps.setString(4, country);
			ps.setString(5, state);
			int i = ps.executeUpdate();

			if (i > 0) {
				out.println("You are successfully Registered!");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
