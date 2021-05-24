<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/menu-style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script type="text/javascript" src="dist/js/menu.js"></script>
<style>
.content {
	margin: 3rem;
}

.lead {
	font-size: 1.5rem;
	font-weight: 300;
}
</style>


</head>
<body>
	<!--wrapper start-->
	<div class="wrapper">

		<!--sidebar start-->
		<div class="sidebar">
			<div class="sidebar-menu">
				<center class="profile">
					<img src="img/avatar.png" alt="">
					<p>User Dashboard</p>
				</center>
				<li class="item"><a href="" class="menu-btn"><i
						class="fas fa-desktop"></i><span>Dashboard</span></a></li>
				<li class="item" id="profile"><a href="#profile"
					class="menu-btn"> <i class="fas fa-user-circle"></i><span>Get
							Quote<i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<a href="#"><i class="fas fa-image"></i><span>Homeowner
								Page</span></a> <a href="userDashboard1"><i class="fas fa-address-card"></i><span>Location
								Page</span></a> <a href=""><i class="fas fa-address-card"></i><span>Property
								Page</span></a> <a href="#"><i class="fas fa-address-card"></i><span>Quote
								Page</span></a>
					</div></li>
				<li class="item" id="messege"><a href="#messege"
					class="menu-btn"> <i class="fas fa-envelope"></i><span>
							Retrieve Quote<i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<a href="#"><i class="fas fa-envelope"></i><span>Retrieve
								Quote Page</span></a> <a href="#"><i class="fas fa-envelope-square"></i><span>Quote
								Summary Page</span></a>
					</div></li>
				<li class="item" id="buyPolicy"><a href="#buyPolicy"
					class="menu-btn"> <i class="fas fa-cog"></i><span>Buy
							Policy <i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<a href="#"><i class="fas fa-lock"></i><span>Password</span></a> <a
							href="#"><i class="fas fa-language"></i><span>Language</span></a>
					</div></li>
				<li class="item" id="cancelPolicy"><a href="#cancelPoicy"
					class="menu-btn"> <i class="fas fa-cog"></i><span>
							Cancel Policy<i class="fas fa-chevron-down drop-down"></i>
					</span></a></li>
				<li class="item" id="renewPolicy"><a href="#renewPolicy"
					class="menu-btn"> <i class="fas fa-cog"></i><span>Renew
							Policy <i class="fas fa-chevron-down drop-down"></i>
					</span></a></li>
				<li class="item" id="viewPolicy"><a href="#viewPolicy"
					class="menu-btn"> <i class="fas fa-cog"></i><span>View
							Policy <i class="fas fa-chevron-down drop-down"></i>
					</span></a></li>
				<li class="item"><a href="" class="menu-btn"><i
						class="fas fa-info-circle"></i><span>Log Out</span></a></li>
			</div>
		</div>
		<!--sidebar end-->
		<!--header menu start-->
		<div class="header">
			<div class="header-menu">
				<div class="title">
					<span class="title-hide">User<span class="sec-span">Dashboard</span></span>
				</div>
				<div class="sidebar-btn">
					<i class="fas fa-bars"></i>
				</div>
				<ul>
					<li><a href=""><i class="fab fa-facebook-f"></i></a></li>
					<li><a href=""><i class="fab fa-twitter"></i></a></li>
					<li><a href=""><i class="fas fa-power-off"></i></a></li>
				</ul>
			</div>
		</div>
		<!--header menu end-->
		<!--main container start-->
		<div class="main-container">
			<div class="content">
				<h1>Hi welcome user</h1>
				<div id="carbon-block" style="margin: 30px auto"></div>
				<div style="margin: 30px auto"></div>
				<p class="lead">well-suited for dashboards, admin panels, and
					documentation websites.</p>
			</div>
		</div>
		<!--main container end-->
	</div>
	<!--wrapper end-->
	<script type="text/javascript">


</script>
</body>
</html>