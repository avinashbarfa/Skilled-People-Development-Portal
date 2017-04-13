package com.spep.unnati;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateData
 */
@WebServlet("/GenerateData")
public class GenerateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
			
		for(double j = 69;j <= 78;j = j + 0.09){
			
			double longitudeVariable = -6.28;
		
		for(double i = 8;i <= 21;i = i + 0.21){
			
			
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int k = 0; k < 5; k++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			String name = sb.toString();
			String contact = sb.toString();
			String gender;
			if(i % 2 == 0){
                gender = "Female";
			}else{
				gender = "Male";
			}
			String skill = sb.toString();
			String country = sb.toString();
			String state = sb.toString();
			String zip = sb.toString();
			String city = sb.toString();
			String address = sb.toString();
			String status = "Not Employed";
			String latitude = String.valueOf(i);
			String longitutde = String.valueOf(j);
		
			PrintWriter out = response.getWriter();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
				PreparedStatement ps = conn.prepareStatement("INSERT INTO labour (fullname,contact,gender,skill,country,state,zip,city,address,latitude,longitude,jobstatus) Values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, contact);
				ps.setString(3, gender);
				ps.setString(4, skill);
				ps.setString(5, country);
				ps.setString(6, state);
				ps.setString(7, zip);
				ps.setString(8, city);
				ps.setString(9, address);
				ps.setString(10, latitude);
				ps.setString(11, longitutde);
				ps.setString(12, status);

				int y = ps.executeUpdate();
				
				if(y > 0) {
					out.println("Labour Is Successfull Registered !");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.print(e1);
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		}
	}


}
