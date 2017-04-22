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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int count = 0;
		PrintWriter out = response.getWriter();

		for (double j = 69; j <= 89; j = j + 0.20) {

			int counter = 0;

			for (double i = 8; i <= 29; i = i + 0.21) {

				String[] firstnamearr = { "Vijay", "Vivek", "Raghav", "Sanjay", "Aayush", "Saurabh", "Sarthak", "Sagar",
						"Sakshi", "Sejal", "Akansha" };
				String random1 = (firstnamearr[new Random().nextInt(firstnamearr.length)]);

				String[] lastnamearr = { "Agrawal", "Taneja", "Gersch", "Jespersen", "Merzdorf", "Vinson", "Harvey",
						"Haerdle" };
				String random2 = (lastnamearr[new Random().nextInt(lastnamearr.length)]);

				String[] contactarr = { "9179686919", "7709244773", "7887554203" };
				String random3 = (contactarr[new Random().nextInt(contactarr.length)]);

				String[] skillarr = { "Tailor", "Agriculture", "Electrician", "Nursing", "Fabrication", "Teacher" };
				String random4 = (skillarr[new Random().nextInt(skillarr.length)]);

				String[] statesarr = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
						"Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka",
						"Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
						"Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand",
						"Uttar Pradesh", "West Bengal" };
				String random5 = (statesarr[new Random().nextInt(statesarr.length)]);

				String[] citiesarr = { "London", "Manchester", "Bristol", "Liverpool", "Edinburgh", "Glasgow", "Leeds",
						"Candiff", "Sheffield", "York", "Brighton", "Belfast", "Cambridge", "Portsmouth", "Coventry",
						"Aberdeen", "Ocford", "Norwich", "Plymouth", "Swansea", "Leicester", "Southampton", "Bath",
						"Exeter", "Dundee" };
				String random7 = (citiesarr[new Random().nextInt(citiesarr.length)]);

				String[] labstatus = { "Employed", "Not Employed" };
				String random8 = (labstatus[new Random().nextInt(labstatus.length)]);

				String[] cmpemployed = { "Reliance Industries", "Tata", "Amul", "Archies", "Bajaj Auto",
						"Bharti Airtel", "Spice Digital" };
				String random9 = (cmpemployed[new Random().nextInt(cmpemployed.length)]);

				char[] pincd = "0123456789".toCharArray();
				StringBuilder sb = new StringBuilder();
				Random random6 = new Random();
				for (int k = 0; k <= 5; k++) {
					char c = pincd[random6.nextInt(pincd.length)];
					sb.append(c);
				}
				String status = random8;
				String employedin;
				if (status == "Employed") {
					employedin = random9;
				} else
					employedin = "";

				String name = random1 + " " + random2;
				String contact = random3;
				String skill = random4;

				String gender;
				if (random1 == "Sakshi" || random1 == "Sejal" || random1 == "Akansha") {
					gender = "Female";
				} else {
					gender = "Male";
				}

				String country = "India";
				String state = random5;
				String zip = sb.toString();
				String city = random7;
				String latitude = String.valueOf(i);
				String longitutde = String.valueOf(j);

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
					PreparedStatement ps = conn.prepareStatement(
							"INSERT INTO labour (fullname,contact,gender,skill,country,state,zip,city,latitude,longitude,jobstatus,employedin) Values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
					ps.setString(12, employedin);

					int y = ps.executeUpdate();

					if (y > 0) {
						count++;
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

				counter++;
			}
		}
		out.println(" " + count);
	}

}
