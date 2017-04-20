package com.spep.unnati;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String organization = request.getParameter("tname");
		String contact = request.getParameter("tcontact");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String password = request.getParameter("passwd");
		PrintWriter out = response.getWriter();
		int i = SignupValidate.tValidate(organization, password, contact, country, state, zip, city);
		if (i > 0) {
		/*	out.println("You are successfully Registered!");*/
			HttpSession session = request.getSession();
			session.setAttribute("Organization", organization);
			response.sendRedirect("successsignup.jsp");
		}
	}

}
