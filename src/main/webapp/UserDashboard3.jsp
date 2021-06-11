<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/UserDashboard1.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
.error {
	color: red;
	align: left;
}
</style>
</head>
<body>
	<div class="btn">
		<span class="fas fa-bars"></span>
	</div>

	<nav class="sidebar">
		<nav class="sidebar">

			<center class="profile">
				<img src="img/avatar.png" alt="">
				<p>User Dashboard</p>
			</center>



			<div class="text">
				<i class="fasfa-desktop"> User Dashboard
			</div>

			<ul>
			<li><button>
					<a href="premiumDetails"> Premium Details</a>
					</button></li>

				<li>
					<button class="feat-btn">
						Get Quote <span class="fas fa-caret-down first"></span>
					</button>
					<ul class="feat-show">
						<li><button id="homeownerbtn">HomeOwner Page</button></li>
						<li><button id="locationbtn">Property & Location
								Page</button></li>


					</ul>
				</li>
				<li>
					<button class="serv-btn">
						<i class="fas fa-user-circle"></i> Retrieve Quote <span
							class="fas fa-caret-down second"></span>
					</button>
					<ul class="serv-show">
						<li><button ><a href="retriveQuote" >Retrieve Quote Page</a></button></li>
						<li><button><a href="ViewSummary">Quote Summary Page</a></button></li>
					</ul>
				</li>
				<li>
					<button class="buy-btn" id="buyPolicyBtn">
						<i class="fas fa-address-card"></i> Buy Policy
					</button>
				<li><button>
						<i class="fas fa-image"></i> <a href="cancelPolicyByUser">Cancel Policy
					</a></abbr></button></li>
				<li><button><a href="home.jsp"><i class="fas fa-info-circle"></i>
						Log Out</a></button></li>
			</ul>
		</nav>
	</nav>


	<!-- Image Used for background  -->

	<center>
		<div id="right">
			<div id="img" class="imalign">
				<img src="img/S1.png" alt="image" height="600"> <img
					src="img/S2.png" alt="iamge" height="400">
			</div>
			<h1>${msg}</h1>
		</div>

	</center>

	<! --------------------------   Home Owner Entity ------------------------>
	<div id="homeOwnerPage" class="homestyle">
		<form:form method="POST" modelAttribute="home" action="homeowner">

			<center>
				<br> <br> <br> <br>
				<h2>Home Owner Page</h2>
				<table cellspacing="5px" cellpadding="5%" align="center">
					<tr>
						<td><label>Owner ID</label></td>
						<td><form:input path="ownerId" type="number" name="o_Id"
								id="id" placeholder="Enter your ID" /></td>
								<td><form:errors path="ownerId" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="fname" type="text" name="fn" id="fname"
								placeholder="Enter your First Name" /></td>
								<td><form:errors path="fname" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lname" type="text" name="ln" id="lname"
								placeholder="Enter your Last Name" /></td>
							<td><form:errors path="lname" cssClass="error" /></td>
					</tr>

					<%-- <tr>
					<td><label>Enter Date of Birth</label></td>
					<td><form:input path="dob" type="date" name="dob" id="dob" /></td>
				</tr>  --%>

					<tr>
						<td><label>Are you retired</label></td>
						<td><form:select path="retired" name="retired">
								<form:option value="Yes" label="Yes" />
								<form:option value="No" label="No" />
							</form:select></td>
							<td><form:errors path="retired" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Social Security number </label></td>
						<td><form:input path="socialSocietyNumber" type="number"
								name="s_no" id="SSN"
								placeholder="Enter your Social Security Number" /></td>
								<td><form:errors path="socialSocietyNumber" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Email Address</label></td>
						<td><form:input path="email" type="email" name="owner_email"
								id="emailId" placeholder="Enter your EmailID" /></td>
								<td><form:errors path="email" cssClass="error" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit" name="" onclick="showmessage()"></td>
						
					</tr>
				</table>
			</center>

		</form:form>
	</div>
<script>function showmessage()
		{var m=${message};
			window.alert(m);
		}
	</script>













	<!-----------------------------------------------   Policy Page started -------------------------------------------->


	<div id="policyPage" class="homestyle">
		<form:form method="POST" action="buypolicy" modelAttribute="policy">
			<center>
				<br> <br> <br> <br>
				<h2>Buy Policy Page</h2>
				<table cellspacing="5px" cellpadding="5%" align="center">
					<tr>
						<td>Start Date<form:input path="effectiveDate" />
						</td>
						<td>End Date<form:input path="endDate" />
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Buy Policy" /></td>
					</tr>
				</table>
			</center>
		</form:form>
	</div>



	<!-----------------------------------------------   Policy Page End -------------------------------------------->










	<div id="page" align="center">

		<form:form method="POST" modelAttribute="location" action="location">




			<! --------------- property page --------->

			<div id="propertyPage" class="homestyle">

				<h2>Property Page</h2>
				<table cellspacing="5px" cellpadding="5%">

					<tr>
						<td><label>Property ID</label></td>
						<td><form:input path="property.property_id" name="p_Id"
								id="id" placeholder="Enter your Property ID" /></td>
								<td><form:errors path="property.property_id" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Market Value</label></td>
						<td><form:input path="property.market_value" name="mv"
								id="property" placeholder="$" /></td>
								<td><form:errors path="property.market_value" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Build Year</label></td>
						<td><form:input path="property.year_built" name="by"
								id="buildyear" placeholder="Square Feet" /></td>
								<td><form:errors path="property.year_built" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>square footage</label></td>
						<td><form:input path="property.square_footage" name="sf"
								id="buildyear" placeholder="Square Footage" /></td>
								<td><form:errors path="property.square_footage" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Dwelling Style</label></td>
						<td><form:select path="property.dwelling_type" name="ds">

								<form:option value="-1" label="--Select--" />
								<form:option value="1_st" label="1 Story" />
								<form:option value="1.5_st" label="1.5 Story" />
								<form:option value="2_st" label="2" />
								<form:option value="2.5_st" label="2.5 Story" />
								<form:option value="3_st" label="3" />


							</form:select></td>
							<td><form:errors path="property.dwelling_type" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Roof Material</label></td>
						<td><form:select path="property.roof_material" name="rm">

								<form:option value="-1" label="--Select--" />
								<form:option value="Concrete" label="Concrete" />
								<form:option value="Clay" label="Clay" />
								<form:option value="Rubber" label="Rubber" />
								<form:option value="Steel" label="Steel" />
								<form:option value="Tin" label="Tin" />
								<form:option value="Wood" label="Wood" />

							</form:select></td>
							<td><form:errors path="property.roof_material" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Type of Garage</label></td>
						<td><form:select path="property.garage_type" name="tg">

								<form:option value="-1" label="--Select--" />
								<form:option value="Attached" label="Attached" />
								<form:option value="Detached" label="Detached" />
								<form:option value="Basement" label="Basement" />
								<form:option value="Built-in" label="Built-in" />
								<form:option value="None" label="None" />

							</form:select></td>
							<td><form:errors path="property.garage_type" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Numeber of Full Baths</label></td>
						<td><form:select path="property.full_baths" name="fb">
								<form:option value="-1" label="--Select--" />
								<form:option value="1" label="1" />
								<form:option value="2" label="2" />
								<form:option value="3" label="3" />
							</form:select></td>
							<td><form:errors path="property.full_baths" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Numeber of Half Baths</label></td>
						<td><form:select path="property.half_baths" name="hb">
								<form:option value="-1" label="--Select--" />
								<form:option value="1" label="1" />
								<form:option value="2" label="2" />
								<form:option value="3" label="3" />
							</form:select></td>
							<td><form:errors path="property.half_baths" cssClass="error" /></td>
					</tr>

					<%-- 		<tr>
					<td><label>Do you have Swimming Pool</label></td>
					<td><label>Yes</label> <form:input path="pool" type="radio" id="yes" name="btn"
						value="yes"/> <label>No</label> <form:input path="pool" type="radio" id="no"
						name="btn" value="no"/></td>
				</tr> --%>

					<tr>
						<td><input type="button" value="next" id="next"></td>
					</tr>
				</table>

			</div>





			<! -----------------Location page -------------------->


			<div id="locationPage" class="homestyle">

				<h2>Location Page</h2>
				<table cellspacing="5px" cellpadding="5%">

					<tr>
						<td><label>Location Id</label></td>
						<td><form:input path="location_id" name="id" id="locationid"
								placeholder="Enter your Location id" /></td>
								<td><form:errors path="location_id" cssClass="error" /></td>
					</tr>



					<tr>
						<td><label>Residence Type</label></td>
						<td><form:select path="residence_type" name="ds">

								<form:option value="-1" label="--Select--" />
								<form:option value="Single-Family Home" label="Single-Family Home" />
								<form:option value="Condo" label="Condo" />
								<form:option value="Townhouse" label="Townhouse" />
								<form:option value="Row House" label="Row House" />
								<form:option value="Duplex" label="Duplex" />
								<form:option value="Apartment" label="Apartment" />

							</form:select></td>
							<td><form:errors path="residence_type" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Address Line-1</label></td>
						<td><form:input path="address_line_1" name="a1" id="address1"
								placeholder="Enter your Address Line 1" /></td>
								<td><form:errors path="address_line_1" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Address Line-2</label></td>
						<td><form:input path="address_line_2" name="a2" id="address2"
								placeholder="Enter your Address Line 2" /></td>
								<td><form:errors path="address_line_2" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><form:input path="city" name="city" id="city"
								placeholder="Enter your City" /></td>
								<td><form:errors path="city" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>State</label></td>
						<td><form:input path="location_state" name="state" id="state"
								placeholder="Enter your State" /></td>
								<td><form:errors path="location_state" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Zip Code</label></td>
						<td><form:input path="zip_code" name="zip" id="zipcode"
								placeholder="Enter your ZIP Code" /></td>
								<td><form:errors path="zip_code" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Residence Use</label></td>
						<td><form:select path="residence_use" name="r_user">

								<form:option value="-1" label="--Select--" />
								<form:option value="Primary" label="Primary" />
								<form:option value="Secondary" label="Secondary" />
								<form:option value="Rental Property" label="Rental Property" />
							</form:select></td>
							<td><form:errors path="residence_use" cssClass="error" /></td>

					</tr>


					<tr>

						<td><input type="button" value="previous" id="previous"></td>
						<td><input type="submit" value="Submit" name=""></td>
					</tr>
				</table>
			</div>

		</form:form>
	</div>

	


	<script>

	
	
		$(document).ready(function() {
			$('#page').hide();
			$('#homeOwnerPage').hide();
			$('#policyPage').hide();
			$('#sidebar').show();
			$('#ownerPage').hide();
			$('#summary1').hide();
			$('#summary2').hide();
			$('#summary3').hide();
		});

		$('#homeownerbtn').click(function() {
			$('#homeOwnerPage').show();
			$('#page').hide();
			$('#sidebar').hide();
			$('#right').hide();
			$('#policyPage').hide();
			$('#toptest').hide();
		});

		$('#locationbtn').click(function() {
			$('#page').show();
			$('#propertyPage').show();
			$('#locationPage').hide();
			$('#homeOwnerPage').hide();
			$('#sidebar').hide();
			$('#right').hide();
			$('#policyPage').hide();
		});

		$('#previous').click(function() {
			$('#page').show();
			$('#locationPage').hide();
			$('#propertyPage').show();
			$('#homeOwnerPage').hide();
			$('#sidebar').hide();
			$('#right').hide();
		});

		$('#next').click(function() {
			$('#page').show();
			$('#locationPage').show();
			$('#propertyPage').hide();
			$('#sidebar').hide();
			$('#right').hide();
		});


		$('#buyPolicyBtn').click(function() {
			$('#quote').hide();
			$('#page').hide();
		 	$('#policyPage').show();
		/*     $('#summary1').show(); */
		    $('#right').hide();
		});

		$('.btn').click(function() {
			$(this).toggleClass("click");
			$('.sidebar').toggleClass("show");
		});
		$('.feat-btn').click(function() {
			$('nav ul .feat-show').toggleClass("show");
			$('nav ul .first').toggleClass("rotate");
		});
		$('.serv-btn').click(function() {
			$('nav ul .serv-show').toggleClass("show1");
			$('nav ul .second').toggleClass("rotate");
		});
		$('.buy-btn').click(function() {
			$('nav ul .buy-show').toggleClass("show2");
			$('nav ul .third').toggleClass("rotate");
		});
		$('nav ul li').click(function() {
			$(this).addClass("active").siblings().removeClass("active");
		});
	</script>
		
</body>
</html>