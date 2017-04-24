<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

	<div class="top-header">
		<div class="container">
			<a href="institutedashboard.jsp"><img src="img/logo.png"
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
				<button class="tablinks" onclick="openCategory(event, 'addlabour')">ADD
					LABOUR</button>
				<button class="tablinks" onclick="openCategory(event, 'viewLabour')">VIEW
					LABOUR</button>
			</div>

			<div id="addlabour" class="tabcontent" style="height: 720px;">
				<h3 style="text-align: center; color: darkcyan;">Add Labour</h3>
				<form action="AddLabour" method="POST">
					<div class="col-md-12">
						<label for="fname">Full Name :</label> <input type="text"
							name="name" placeholder="Enter Full Name.." required="required">
					</div>
					<div class="col-md-6">
						<label for="lname">Contact Number :</label> <input type="text"
							name="contact" placeholder="Contact Number.." required="required"
							onchange="contactFunction()">
					</div>
					<div class="col-md-6">
						<label for="zipcode">Zip Code :</label> <input type="text"
							name="zip" placeholder="Pin Code" required="required"
							onchange="pinFunction()">
					</div>
					<div class="col-md-6">
						<label for="gender">Gender :</label> <select name="gender">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select>
					</div>
					<div class="col-md-6">
						<label for="skill">Skill :</label> <select name="skill">
							<option value="Tailor">Tailor</option>
							<option value="Agriculture">Agriculture</option>
							<option value="Nursing">Nursing</option>
							<option value="Fabrication">Fabrication</option>
							<option value="Electrician">Electrician</option>
							<option value="Teacher">Teacher</option>
						</select>
					</div>

					<div class="col-md-6">
						<label for="country">Country :</label> <select id="country"
							name="country">
							<option value="India">India</option>
						</select>
					</div>
					<div class="col-md-6">
						<label for="state">State :</label> <select id="state" name="state">
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

					<div class="col-md-4">
						<label for="city">Address :</label> <input type="text" name="city"
							id="txtAddress" placeholder="Address.." required="required" onchange="GetLocation()">

					</div>
					
					<script type="text/javascript">
						function GetLocation() {
							var geocoder = new google.maps.Geocoder();
							var address = document.getElementById("txtAddress").value;
							geocoder
									.geocode(
											{
												'address' : address
											},
											function(results, status) {
												if (status == google.maps.GeocoderStatus.OK) {
													var latitude = results[0].geometry.location
															.lat();
													var longitude = results[0].geometry.location
															.lng();
													//alert("Latitude: " + latitude + "\nLongitude: " + longitude);
													document
															.getElementById('latitude').value = latitude;
													document
															.getElementById('longitude').value = longitude;
													document
															.getElementById('demo9').innerHTML = "Latitude: "
															+ latitude;
													document
															.getElementById('demo10').innerHTML = "Longitude: "
															+ longitude;
												} else {
													alert("Request failed.")
												}
											});
						};
					</script>
					<div class="col-md-6" style="margin-top: 35px;">
						<div id="demo9" style="margin-left: 20px;display:none" name="longitude"
							value="longitude"></div>
						<div id="demo10" style="margin-left: 20px;display:none" name="longitude"
							value="longitude"></div>
					</div>
					<center style="color:red">Note: 'Click on Get Location Button' before Submitting Form.</center>
					<input type="hidden" name="latitude" id="latitude"> <input
						type="hidden" name="longitude" id="longitude"> <input
						type="submit" value="Submit"
						style="height: 48px; width: 138px; border-radius: 0; float: right; margin-top: 50px; margin-right: 21px;">

				</form>


			</div>

			<div id="viewLabour" class="tabcontent" style="height: 320px;">

				<h3 style="text-align: center; color: darkcyan;">View Labour
					Details</h3>
				<div class="search-section">
					<form action="InstituteSearchLabour" method="POST">
			
						<center>
							<br>
							<div class="col-md-4">
								<label><h4>Search By :</h4></label> 
								<select name="search-as"
									id="search" style="width: 160px"
									onchange="GetSelectedTextValue()">
									<option value="">-- Filter by --</option>
									<option value="username">USERNAME</option>
									<option value="skill">SKILL</option>
									<option value="state">STATE</option>
								</select>
							</div>
	
							<div id="demo">
								<div class="col-md-5">
									<input type="text" name="searchlabel"
										placeholder="Enter Details to Search...">
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
						</center>
					</form>
				</div>
			</div>
		
			<div id="profile" class="tabcontent" style="height: 468px;">

				<%
					HttpSession check_session2 = request.getSession(false);
					String uname = (String) check_session2.getAttribute("tusername");

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
						PreparedStatement stmt = conn.prepareStatement("SELECT * FROM institute WHERE instiname=?");
						stmt.setString(1, uname);
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {
				%>
				<h4
					style="padding-left: 80px; padding-top: 16px; text-align: left; color: forestgreen;">
					Organisation :
					<%=rs.getString("instiname")%></h4>
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
					Country :
					<%=rs.getString("country")%></h4>
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
				<a href="#" class="fa fa-facebook"></a> <a href="#"
					class="fa fa-twitter"></a> <a href="#" class="fa fa-google"></a> <a
					href="#" class="fa fa-linkedin"></a>
			</div>
			<hr>

			<div class="rights">
				<h6>Some Contents are copied &copy; 2017</h6>
			</div>
		</div>
	</div>
</body>

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
	function pinFunction() {
		var x = document.getElementById('zipcode').value.length;

		if (x > 6 || x < 6) {
			alert("Pin Code Must Not be of 6 Digits.");
		}
	}

	function contactFunction() {
		var x = document.getElementById('contact').value.length;

		if (x > 10 || x < 10) {
			alert("Contact Number Must be of 10 digits.");
		}
	}
</script>
<script src="js/main.js"></script>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBIWcz37GLZrMMHvyAZr-3UGiPU2-JzzBk"></script>

</html>
