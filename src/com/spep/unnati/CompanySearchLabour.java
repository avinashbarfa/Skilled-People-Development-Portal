package com.spep.unnati;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNearestLocations
 */
@WebServlet("/FindNearestLocations")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		doGet(request, response);
	}
	
	ArrayList<String> locator(int numberOfPeople,Double longitude,Double latitude){
		
		ArrayList<String> al = new ArrayList<String>();
		int get = 0;
		double latitudeDist = latitude * 111194.9266;
		double longitudeDist = longitude * 111194.9266;
		int dist = 500;
		Boolean flag = false;
		
		while(al.size() <  numberOfPeople){
			while(/*Data exists*/){
				
				double latitudeOfLabour;//latitude of labour
				double longitudeOfLabour;//longitude of labour
				
				if(latitudeOfLabour <= latitudeDist + dist && latitudeOfLabour >= latitudeDist - dist){
					if(longitudeOfLabour <= latitudeDist + dist && longitudeOfLabour >= latitudeDist - dist){
						//al.add(labour)
						if(al.size() > numberOfPeople || al.size() == numberOfPeople){
							flag = true;
							break;
						}
					}
				}
		    if(flag){
		    	break;
		    }
				
			dist += 500;
		}
		return al;
	}

}
}