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
		String nameOfCompany = request.getParameter("name");
		// System.out.println(name);
		int numberOfPeople = Integer.parseInt(request.getParameter("number"));
		// System.out.println(number);
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati","root", "root");
			PreparedStatement ps = conn.prepareStatement("SELECT compname,latitude,longitude from company where compname=?");
			ps.setString(1, nameOfCompany);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) { 
				clongitude = Double.parseDouble(rs.getString("longitude")); 
				clatitude = Double.parseDouble(rs.getString("latitude")); 
			}
			
			al = locator(clongitude,clatitude,numberOfPeople);
			Iterator<String> it = al.iterator();
			while (it.hasNext()) {
				out.println("<center>");
				out.println("<br><br>");
				out.println(it.next() + "<br><br>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	String query(double clongitude,double clatitude,int dist){
		
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
	    String query = "SELECT id,fullname,contact,latitude,longitude from labour WHERE longitude <= " + maxLongitude + " and longitude >= " + minLongitude + " and latitude <= " + maxLatitude + " and latitude >= " + minLatitude;
	    return query;
	}
	
	ArrayList<String> locator(double clongitude,double clatitude,int numberOfPeople) {

		ArrayList<String> al = new ArrayList<>();
		
		int dist = 100000;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			
			int count = 0;
			
			while(count <= numberOfPeople){
				
			    count = 0;
				
				PreparedStatement ps1 = conn.prepareStatement(query(clongitude,clatitude,dist));
				ResultSet rs1 = ps1.executeQuery();
				
			    while(rs1.next()){
				    count++;
			    }
			    
			    if(count <= numberOfPeople){
			    	dist += 100000;
			    }
			    
			}
			

			PreparedStatement ps2 = conn.prepareStatement(query(clongitude,clatitude,dist));
			ResultSet rs2 = ps2.executeQuery();
			
			int count2 = 0;
			
			while (rs2.next()) {
				
				String name = rs2.getString(2);
				String contact = rs2.getString(3);
				String concat = name + " " + contact;
				al.add(concat);
				count2++;
				
				if(count2 == numberOfPeople){
					break;
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}