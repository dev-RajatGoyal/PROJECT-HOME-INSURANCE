<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/adminnstyle1.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>

	<div class="btn">
		<span class="fas fa-bars"></span>
	</div>
	<nav class="sidebar">
		<nav class="sidebar">
			<center class="profile">
				<img src="img/admin.png" alt="">
				<p>Admin Dashboard</p>
			</center>
			</div>
			<div class="text">Admin Dashboard</div>
			<ul>
				<li class="active"><button>Dashboard</button></li>
				<li>
					<button class="feat-btn">
						View All Policy <span class="fas fa-caret-down first"></span>
					</button>
					<ul class="feat-show">
						<li><button id="alluserpolicy">All User Policy</button></li>

						<li><button id="userpolicy">Single User Policy</button></li>

					</ul>
				</li>
				<li>
					<button class="serv-btn">
						Renew Policy <span class="fas fa-caret-down second"></span>
					</button>
					<ul class="serv-show">
						<li><button>Retrieve Policy Page</button></li>

					</ul>
				</li>
				<li>
					<button class="buy-btn">
						Cancel Policy <span class="fas fa-caret-down third"></span>

					</button>
					<ul class="buy-show">
						<li><button>Cancel Policy</button></li>
					</ul>
				</li>

				<li><button><a href="home.jsp"><i class="fas fa-info-circle"></i>
						Log Out</a></button></li></li>
			</ul>
		</nav>
	</nav>
	<div class="content" id="b-image">
		<div id="right">
			<div id="img">
				<img src="img/S1.png" alt="image" height="600"> <img
					src="img/S2.png" alt="iamge" height="400">
			</div>
		</div>
		<p>You can view admin functionalities</p>
	</div>


	<!----------------------------------------- VIEW All POLICIES  ---------------------------------->

	<div id="viewAllPolicy">
		<div id="quote" align="center">
			<table class="content-table">
				<thead>
					<tr>
						<td>Policy Id</td>
						<td>Effective Date</td>
						<td>End Date</td>
						<td>Term</td>
						<td>Quote Id</td>
						<td>User Name</td>
						<td>Policy Status</td>
						<td>Active Policy</td>
						<td>Renew Policy</td>
						<td>Cancel Policy</td>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="policy" items="${listPolicies}">
						<tr>
							<td>${policy.getPolicyId()}</td>
							<td>${policy.getEffectiveDate()}</td>
							<td>${policy.getEndDate()}</td>
							<td>${policy.getPolicyTerm()}</td>
							<td>${policy.getQuote().getQuote_id()}</td>
							<td>${policy.getUser().getUsername()}</td>
							<td>${policy.getPolicyStatus()}</td>
							<td><a href="activePolicy?policyId=${policy.getPolicyId()}">Active policy</a></td>
							<td><a href="renewPolicy?policyId=${policy.getPolicyId()}">Renew</a></td>
							<td><a href="cancelPolicy?policyId=${policy.getPolicyId()} ">Cancel</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>
	<!----------------------------------------- End of VIEW All POLICIES  ---------------------------------->



			<!------------------------------------------- VIEW POLICY by ID---------------------------------->

			<div id="viewPolicy">
				<div id="quote" align="center">
					<table class="content-table">
						<thead>
							<tr>
								<td>Policy Id</td>
								<td>Effective Date</td>
								<td>End Date</td>
								<td>Policy Status</td>
								<td>Term</td>
								<td>Quote Id</td>
								<td>User Id</td>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>${policy.getPolicyId()}</td>
								<td>${policy.getEffectiveDate()}</td>
								<td>${policy.getEndDate()}</td>
								<td>${policy.getPolicyStatus()}</td>
								<td>${policy.getPolicyTerm()}</td>
								<td>${policy.getQuote().getQuote_id()}</td>
								<td>${policy.getUser().getuserid()}</td>
							</tr>
						</tbody>

					</table>
				</div>
				
			</div>

	<!---------------------------- End of VIEW POLICY by USERID -------------------------------------------->

	<script>
	$(document).ready(function() {
		$('#viewPolicy').hide();
		$('#main').show();
		$('#viewAllPolicy').hide();
	});

	$('#userpolicy').click(function() {
		$('#b-image').hide();
		$('#main').hide();
		$('#viewAllPolicy').hide();
		$('#viewPolicy').show();
	});

	$('#alluserpolicy').click(function() {
		$('#b-image').hide();
		$('#main').hide();
		$('#viewPolicy').hide();
		$('#viewAllPolicy').show();
	});
		
	</script>

	<script>
    $('.btn').click(function(){
      $(this).toggleClass("click");
      $('.sidebar').toggleClass("show");
    });
      $('.feat-btn').click(function(){
        $('nav ul .feat-show').toggleClass("show");
        $('nav ul .first').toggleClass("rotate");
      });
      $('.serv-btn').click(function(){
        $('nav ul .serv-show').toggleClass("show1");
        $('nav ul .second').toggleClass("rotate");
      });
     $('.buy-btn').click(function(){
        $('nav ul .buy-show').toggleClass("show2");
        $('nav ul .third').toggleClass("rotate");
      });
      $('nav ul li').click(function(){
        $(this).addClass("active").siblings().removeClass("active");
      });
    </script>

</body>
</html>
