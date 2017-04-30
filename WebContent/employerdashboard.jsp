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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<style>
#demo {
	display: none;
}

#demo1 {
	display: none;
}

#demo2 {
	display: none;
}
</style>

<body>
	<%
		HttpSession check_session1 = request.getSession(false);
		String uname = (String) check_session1.getAttribute("eusername");
	%>
	<div class="top-header">
		<div class="container">
			<a href="employerdashboard.jsp"><img src="img/logo.png"
				style="float: left;"></a> <a href="Logout"
				style="float: right; padding-top: 12px;"><span
				class="glyphicon glyphicon-log-out"></span>&nbsp;LOGOUT</a>
		</div>
	</div>

	<div class="institute-nav">
		<div class="container">
			<hr>

			<div class="tab">
				<button class="tablinks" onclick="openCategory(event, 'profile')"
					id="defaultOpen">PROFILE</button>
				<button class="tablinks"
					onclick="openCategory(event, 'searchLabour')">SEARCH
					LABOUR</button>
				<button class="tablinks" onclick="openCategory(event, 'viewLabour')">VIEW
					LABOUR</button>
			</div>
		

		
			<div id="searchLabour" class="tabcontent">
				<div class="col-md-12">
					<h3 style="text-align: center; color: darkcyan;">Search Labours	For Your Work To Be Done</h3>
				</div>

				<div class="sample" style="height: 100px;">
					<!-- DON'T DELETE THIS SECTION -->
				</div>
						
				<form action="CompanySearchLabour" method="POST">
				
					<div class="col-md-6">
						<select name="skill-wise" style="margin-top: 8px;">
							<option value="">-- select skill --</option>
							<option value="Tailor">Tailor</option>
							<option value="Agriculture">Agriculture</option>
							<option value="Nursing">Nursing</option>
							<option value="Fabrication">Fabrication</option>
							<option value="Electrician">Electrician</option>
							<option value="Teacher">Teacher</option>
						</select>
					</div>
					<div class="col-md-3">
						<input type="text" name="number" placeholder="Enter number of people..">	
					</div>
					<div class="col-md-12">
						<input type="submit" value="Search">
					</div>
				</form>
			</div>
	
			<div id="viewLabour" class="tabcontent">
				<%
					request.setAttribute("uname", uname);
				%>
			
					<div class="col-md-12">
						<h3 style="text-align: center; color: darkcyan;">View Labour Details</h3>
					</div>
					
					<form action="SearchLabour" method="POST">
	
						<div class="sample" style="height: 100px;">
							<!-- DON'T DELETE THIS SECTION -->
						</div>
							
							<div class="col-md-2">
								<label><h4>Search By :</h4></label>
							</div>
							<div class="col-md-2">
								<select name="search-as"
									id="search" style="width: 160px" onchange="GetSelectedTextValue()">
									<option value="">-- Filter by --</option>
									<option value="username">USERNAME</option>
									<option value="skill">SKILL</option>
									<option value="state">STATE</option>
								</select>
							</div>
	
							<div id="demo">
								<div class="col-md-5">
									<input type="text" name="searchlabel"
										placeholder="Enter Details to Search..." style="margin-top:0px"/>
								</div>
							</div>
	
							<div id="demo1">
								<div class="col-md-5">
									<select name="skill-wise">
										<option value="">-- select skill --</option>
										<option value="Tailor">Tailor</option>
										<option value="Agriculture">Agriculture</option>
										<option value="Nursing">Nursing</option>
										<option value="Fabrication">Fabrication</option>
										<option value="Electrician">Electrician</option>
										<option value="Teacher">Teacher</option>
									</select>
								</div>
							</div>
	
							<div id="demo2">
								<div class="col-md-5">
									<select name="state-wise">
										<option value="">-- Select State --</option>
										<option value="Andra Pradesh">Andra Pradesh</option>
										<option value="Arunachal Pradesh">Arunachal Pradesh</option>
										<option value="Assam">Assam</option>
										<option value="Bihar">Bihar</option>
										<option value="Chhattisgarh">Chhattisgarh</option>
										<option value="Goa">Goa</option>
										<option value="Gujarat">Gujarat</option>
										<option value="Haryana">Haryana</option>
										<option value="Himachal Pradesh">Himachal Pradesh</option>
										<option value="Jammu and Kashmir">Jammu and Kashmir</option>
										<option value="Jharkhand">Jharkhand</option>
										<option value="Karnataka">Karnataka</option>
										<option value="Kerala">Kerala</option>
										<option value="Madhya Pradesh">Madhya Pradesh</option>
										<option value="Maharashtra">Maharashtra</option>
										<option value="Manipur">Manipur</option>
										<option value="Meghalaya">Meghalaya</option>
										<option value="Mizoram">Mizoram</option>
										<option value="Nagaland">Nagaland</option>
										<option value="Odisha">Odisha</option>
										<option value="Punjab">Punjab</option>
										<option value="Rajasthan">Rajasthan</option>
										<option value="Sikkim">Sikkim</option>
										<option value="Tamil Nadu">Tamil Nadu</option>
										<option value="Telangana">Telangana</option>
										<option value="Tripura">Tripura</option>
										<option value="Uttar Pradesh">Uttar Pradesh</option>
										<option value="Uttarakhand">Uttarakhand</option>
										<option value="West Bengal">West Bengal</option>
									</select>
								</div>
							</div>
	
							<div class="col-md-3">
								<input type="submit" name="submit" value="View Details"
									style="height: 48px; width: 138px; border-radius: 0; float: right; margin-right: 18px">
							</div>
					
				</form>

			</div>

			<div id="profile" class="tabcontent">
				<%
					if (uname != null) {
				%>
				<h3 style="text-align: center; color: darkcyan;">
					Welcome
					<%=uname%>
				</h3>
				<%
					} else {
						response.sendRedirect("login.jsp");
					}
				%>

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unnati", "root", "root");
						PreparedStatement stmt = conn.prepareStatement("SELECT * FROM company WHERE compname=?");
						stmt.setString(1, uname);
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {
				%>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					Company Name :
					<%=rs.getString("compname")%></h4>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					Contact Number :
					<%=rs.getString("contact")%></h4>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					State :
					<%=rs.getString("state")%></h4>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					Zip Code :
					<%=rs.getString("zip")%></h4>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					Address :
					<%=rs.getString("city")%></h4>

				<%
					}
						conn.close();
					} catch (Exception e) {
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
				<a href="https://www.facebook.com/SkillIndiaOfficial/" class="fa fa-facebook"></a>
					<a href="https://twitter.com/MSDESkillIndia" class="fa fa-twitter"></a>
			</div>
			<hr>

			<div class="rights">
				<h6>All Rights are Reserved &copy; 2017</h6>
			</div>
		</div>
	</div>
</body>

<script src="js/main.js"></script>
<script>
	function GetSelectedTextValue() {
		var selectedText = document.getElementById('search').value;
		var selectedValue = selectedText;
		var x = document.getElementById('demo');
		var k = document.getElementById('demo1');
		var z = document.getElementById('demo2');

		if (selectedValue == "username") {
			x.style.display = 'block';
			k.style.display = 'none';
			z.style.display = 'none';
		} else if (selectedValue == "skill") {
			k.style.display = 'block';
			x.style.display = 'none';
			z.style.display = 'none';
		} else if (selectedValue == "state") {
			z.style.display = 'block';
			k.style.display = 'none';
			x.style.display = 'none';
		}
	}
</script>
</html>
