<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/adminnstyle.css">
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
						<li><button>All User Policy</button></li>

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

				<li><button>Log Out</button></li>
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
						<td><button id="buyPolicyBtn">Buy Policy</button></td>
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
		});

		$('#userpolicy').click(function() {
			$('#b-image').hide();
			$('#main').hide();
			$('#viewPolicy').show();
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
