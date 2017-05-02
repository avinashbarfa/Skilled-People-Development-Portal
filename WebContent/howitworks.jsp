<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Unnati : About Us</title>
	<meta charset="utf-8">
	<meta name="Job Protal"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="shortcut icon" href="img/logo.png"/>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
	<link rel="stylesheet" type="text/css" href="css/main2.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>

	
<body>
	
	<div class="mobile-nav">
	 	<%@ include file="navigation.jsp" %>
    </div>
	
	 <div class="desktop-nav"> 
		<div class="container">
			<a href="index.jsp"><img src="img/logo.png" style="float: left;"></a>
			
				<div class="nav-medium" id="myNavmedium">
  					<a href="howitworks.jsp">HOW IT WORKS</a>
					<a href="about.jsp">ABOUT US</a>
					<a href="signup.html"><span class="glyphicon glyphicon-log-in">&nbsp;</span>SIGN UP</a>
					<a href="login.jsp"><span class="glyphicon glyphicon-log-in">&nbsp;</span>LOGIN</a>
					<a href="javascript:void(0);" class="icon" onclick="myNavigation()">&#9776;</a>
				</div>
			
		</div>
	</div>
		
	<div class="container">
		
		<h2><center>HOW IT WORKS</center></h2>

	<div class="col-md-12">
	<h4 style="color: indigo;font-size: 26px;font-family: serif;">Training Center :</h4>
	<pre>
	Step 1: Training Center has to register on own our portal. 
	
	Step 2: After that they can login to our portal with the ITI name as Username and Password.
	
	Step 3: Training Center will register people on the portal, whom they have given training.
	
	Step 4: After Successfully Registration of Labour we have the details of person.
	
	
		  
	</pre>
	</div>
		
	
	<div class="col-md-12">
	<h4 style="color: indigo;font-size: 26px;font-family: serif;">Company :</h4>
	<pre>
	Step 1: Company has to register on own our portal. 
	
	Step 2: After that they can login to our portal with the Company name as Username and Password.
	
	Step 3: Company can now search skilled labours nearest to them.
	
	Step 4: They will get the details of the labour.
	
   	Step 5: They can manually contact to labour via contact number and get their work done.
			
			
	</pre>
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
<script type="text/javascript" src="https://platform.linkedin.com/badges/js/profile.js" async defer></script>
</html>
