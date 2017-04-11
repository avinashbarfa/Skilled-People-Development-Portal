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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ESignup
 */
@WebServlet("/ESignup")
public class ESignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ESignup() {
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
		String organization = request.getParameter("orgname");
		String contact = request.getParameter("contact");
		String zip = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String password = request.getParameter("passwd");
		String address = request.getParameter("add");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO company (compname,userpass,contact,country,state,zip,city,address) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, organization);
			ps.setString(2, password);
			ps.setString(3, contact);
			ps.setString(4, country);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, city);
			ps.setString(8, address);
			int i = ps.executeUpdate();

			if (i > 0) {
				out.println("You are successfully Registered!");
				HttpSession session = request.getSession();
				session.setAttribute("Organization", organization);
				response.sendRedirect("login.html");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
