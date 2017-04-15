<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<title>UNNATI : DASHBOARD</title>
<meta charset="utf-8">
<meta name="Job Protal" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" href="img/logo.png" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />


<body>

	<div class="top-header">
		<div class="container">
			<a href="index.html"><img src="img/logo.png" style="float: left;"></a>
			<a href="Logout" style="float: right; padding-top: 12px;"><span
				class="glyphicon glyphicon-log-out"></span>&nbsp;LOGOUT</a>
		</div>
	</div>

	<div class="institute-nav">
		<div class="container">
			<hr>
			<div class="tab">
				<button class="tablinks" onclick="openCategory(event, 'profile')" id="defaultOpen">PROFILE</button>
				<button class="tablinks" onclick="openCategory(event, 'searchLabour')">SEARCH LABOUR</button>
				<button class="tablinks" onclick="openCategory(event, 'viewLabour')">VIEW LABOUR</button>
			</div>

			<div id="searchLabour" class="tabcontent">
				
				<h3 style="text-align: center;color: darkcyan;">Search Labours For Your Work To Be Done</h3>
				
				
				<h2>TAsk to be done By Apurv and Rushin</h2>
					
			</div>

			<div id="viewLabour" class="tabcontent">
				
				<h3 style="text-align: center;color: darkcyan;">View Labour Details</h3>
				<form action="SearchLabour" method="POST">
			 		<input type="text" name="searchlabel" placeholder="Enter Username to Search..." required="required" style="margin-top: 18px;width: 860px">
			 		
			 		<input type="submit" name="submit" value="View Details"  style="height: 48px;width: 138px;border-radius: 0;float: right;margin-top: 16px;
    							margin-right: 21px;" > 			 	
			 	</form>
				
			</div>

			<div id="profile" class="tabcontent" style="height: 468px;">
				<%
				HttpSession check_session = request.getSession(false);
				String uname = (String)session.getAttribute("username");
				
				if(uname != null) {	
					%>
				<h3 style="text-align: center;color: darkcyan;">
					Welcome
					<%= uname %>
				</h3>
				<%	
				}
				else
				{
					response.sendRedirect("login.html");
				}
				%>

				<%
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati","root","root");
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM company WHERE compname=?");
		stmt.setString(1,uname);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{%>
				<h4 style="padding-left: 80px;padding-top: 16px;text-align: left;color: forestgreen;">
						Company Name   : <%=rs.getString("compname") %></h4>
				<h4 style="padding-left: 80px;padding-top: 16px;text-align: left;color: forestgreen;">
						Contact Number : <%=rs.getString("contact") %></h4>
				<h4 style="padding-left: 80px;padding-top: 16px;text-align: left;color: forestgreen;">
						State          : <%=rs.getString("state") %></h4>
				<h4 style="padding-left: 80px;padding-top: 16px;text-align: left;color: forestgreen;">
						Zip Code       : <%=rs.getString("zip") %></h4>
				<h4 style="padding-left: 80px;padding-top: 16px;text-align: left;color: forestgreen;"
						>City           : <%=rs.getString("city") %></h4>
				
				<%}
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
         %>

			</div>

		</div>
	</div>

	<div class="footer">
		<div class="container">
			<hr>

			<div class="social-link">

				<h3 class="fa fa-text">Follow Us :</h3>
				<a href="#" class="fa fa-facebook"></a> <a href="#"
					class="fa fa-twitter"></a> <a href="#" class="fa fa-google"></a> <a
					href="#" class="fa fa-linkedin"></a>
			</div>
			<hr>

			<div class="rights">
				<h6>Some Contains are copied &copy; 2017</h6>
			</div>
		</div>
	</div>
</body>

<script src="js/main.js"></script>
</html>