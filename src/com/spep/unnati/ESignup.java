package com.spep.unnati;

import java.io.IOException;
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
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		int i = SignupValidate.eValidate(organization, password, contact, country, state, zip, city, latitude,longitude);
		if (i > 0) {
			/*	out.println("You are successfully Registered!");*/
			HttpSession session = request.getSession();
			session.setAttribute("Organization", organization);
			response.sendRedirect("successsignup.jsp");
		}
	}
}
