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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			PreparedStatement ps =conn.prepareStatement("INSERT INTO labour (fullname,contact,gender,skill,country,state,zip,city) Values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2, contact);
			ps.setString(3, zip);
			ps.setString(4, gender);
			ps.setString(5, skill);
			ps.setString(6, country);
			ps.setString(7, state);
			ps.setString(8, city);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				out.println("Labour Is Successfull Registered !");
			}
		} catch (Exception ex) {
			System.out.print(ex);
		}
		
	}

}
