<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Form</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<img class="wave" src="img/wave.png">
	
	<div class="container">
	
		<div class="img">
			<img src="img/bg.svg">
		</div>
		<div class="login-content">
		
			<form action="userdashboard" method="post">
			<div  class="test" >
		<a href="adminLogin">Hi..Admin</a> 
		</div>
				<img src="img/avatar.svg">
				
			<h2 class="title">Welcome User</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>User Id</h5>
           		   		<input type="number" class="input" name="userId" required/>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		  
           		  
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input type="password" class="input" name="password" required/>
            	   </div>
            	  
            	 
				</div>
				
            	<a href="update">Forgot Password?</a>
            	<input type="submit" class="btn" value="Login">
         	    


                      
	<!-- <input type="submit" class="btn" value="Register" onClick="register"> -->
	<a href="register">Click here to register</a>      </form>
	  </div>
    </div>
         
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
