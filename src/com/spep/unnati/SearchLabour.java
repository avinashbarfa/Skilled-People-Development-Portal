package com.spep.unnati;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchLabour
 */
@WebServlet("/SearchLabour")
public class SearchLabour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLabour() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String label = request.getParameter("searchlabel");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
			 PreparedStatement ps=conn.prepareStatement("select * from labour where fullname=?");
			 ps.setString(1, label);  
             out.print("<center><h2>Result:</h2></center>");
             out.print("<table width=50% border=1>");
             ResultSet rs=ps.executeQuery();                
             /* Printing column names */
             ResultSetMetaData rsmd=rs.getMetaData();  
        //     int total=rsmd.getColumnCount();  
            /* out.print("<tr>");  
             
            for(int i=1;i<=total;i++)  
             {  
             out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
             }  
               
             out.print("</tr>"); */ 
                           
             /* Printing result */  
             while(rs.next())  
             {  
                out.print("<tr>");
                out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                out.print("<td>"+rs.getString(1)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                out.print("<td>"+rs.getString(2)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
                out.print("<td>"+rs.getString(5)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
                out.print("<td>"+rs.getString(6)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");
                out.print("<td>"+rs.getString(7)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(8)+"</td>");
                out.print("<td>"+rs.getString(8)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(9)+"</td>");
                out.print("<td>"+rs.getString(9)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(10)+"</td>");
                out.print("<td>"+rs.getString(10)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(11)+"</td>");
                out.print("<td>"+rs.getString(11)+"</td></tr>");
             
             }  
             out.print("</table>");

      }catch (Exception e2)
        {
            e2.printStackTrace();
        }

      finally{out.close();
			
		}
	}

}
