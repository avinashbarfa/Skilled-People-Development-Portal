package com.spep.unnati;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String uname = request.getParameter("uname");
		String password = request.getParameter("passwd");
		String option = request.getParameter("login-as");
		PrintWriter out = response.getWriter();
		if (option.equals("Company")) {
			if (ELoginValidate.validate(uname, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				RequestDispatcher rd = request.getRequestDispatcher("employerdashboard.html");
				rd.forward(request, response);
			} else {
				out.println("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		} else if (option.equals("ITI")) {
			if (TLoginValidate.validate(uname, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				RequestDispatcher rd = request.getRequestDispatcher("institutedashboard.html");
				rd.forward(request, response);
			} else {
				out.println("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		}
		out.close();
	}

}
