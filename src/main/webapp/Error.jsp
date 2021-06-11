<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404</title>
</head>
<link rel="stylesheet" type="text/css" href="css/error-style.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
	

		<div class="img">
			<img src="img/errorimg.jpeg">
		</div>
		<div class="login-content">
			<form>
				<img src="img/404.jpeg">

				<h2 class="title">OOPS....!!!</h2>
				<h3 class="title">${msg1}</h3>
				<h3 class="title">
					We can't seem to find </br> the page you are looking for
				</h3>
				
				<button class="btn"><a href="home.jsp">
						Back to Home Page</a></button>
				
		</div>
		</form>
	</div>

</body>
</html>