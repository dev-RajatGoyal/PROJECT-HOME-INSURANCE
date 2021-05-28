<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript" src="dist/js/menu.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	  <script>
		$(document).ready(function() {
			$('#wrapper').show();
			$('#page1').hide();
			$('#propertyPage1').hide();
			$('#dashboard').show();
		});

		$('#next').click(function() {
			$('#wrapper').hide();
			$('#home').show();
			$('#page').hide();
			$('#propertyPage').hide();
		});
		</script>
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
				<li class="item"><a href="" class="menu-btn"> <iclass ="fasfa-desktop">
						</i> <span>Dashboard</span></a></li>
				<li class="item" id="profile"><a href="#profile"
					class="menu-btn"> <i class="fas fa-user-circle"></i><span>Get
							Quote<i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<button>
							<i class="fas fa-image"></i><span>Homeowner Page</span>
						</button>
						<button>
							<i class="fas fa-address-card"></i><span>Location Page</span>
						</button>
						<button>
							<i class="fas fa-address-card"></i><span>Property Page</span>
						</button>
						<button>
							<i class="fas fa-address-card"></i><span>Quote Page</span>
						</button>
					</div></li>
				<li class="item" id="messege"><a href="#messege"
					class="menu-btn"> <i class="fas fa-envelope"></i><span>
							Retrieve Quote<i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<button><i class="fas fa-envelope"></i><span>Retrieve
								Quote Page</span></button> <button><i class="fas fa-envelope-square"></i><span>Quote
								Summary Page</span></button>
					</div></li>
				<li class="item" id="buyPolicy"><a href="#buyPolicy"
					class="menu-btn"> <i class="fas fa-cog"></i><span>Buy
							Policy <i class="fas fa-chevron-down drop-down"></i>
					</span>
				</a>
					<div class="sub-menu">
						<button><i class="fas fa-lock"></i><span>Password</span></button> <button><i class="fas fa-language"></i><span>Language</span></button>
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







	<! ------------------------ Location and property ----------------------->

<div align="center" id="page">

	<form:form method="POST" modelAttribute="location" action="location">
	
	
	<! --------------- property page --------->

		<div id="propertyPage">

			<h2>Property Page</h2>
			<table cellspacing="5px" cellpadding="5%" align="center">

				<tr>
					<td><label>Property ID</label></td>
					<td><form:input path="property.property_id" name="p_Id"
							id="id" placeholder="Enter your Property ID" /></td>
				</tr>

				<tr>
					<td><label>Market Value</label></td>
					<td><form:input path="property.market_value"  name="mv"
							id="property" placeholder="$" /></td>
				</tr>

				<tr>
					<td><label>Build Year</label></td>
					<td><form:input path="property.year_built" name="by"
							id="buildyear" placeholder="Square Feet" /></td>
				</tr>
				<tr>
					<td><label>square footage</label></td>
					<td><form:input path="property.square_footage" name="sf"
							id="buildyear" placeholder="Square Footage" /></td>
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
				</tr>

				<tr>
					<td><label>Numeber of Full Baths</label></td>
					<td><form:select path="property.full_baths"  name="fb">
							 <form:option value="-1" label="--Select--" />
							<form:option value="1" label="1" />
							<form:option value="2" label="2" />
							<form:option value="3" label="3" />
					</form:select></td>
				</tr>

				<tr>
					<td><label>Numeber of Half Baths</label></td>
					<td><form:select path="property.half_baths" name="hb">
							<form:option value="-1" label="--Select--" />
							<form:option value="1" label="1" />
							<form:option value="2" label="2" />
							<form:option value="3" label="3" />
					</form:select></td>
				</tr>

		<%-- 		<tr>
					<td><label>Do you have Swimming Pool</label></td>
					<td><label>Yes</label> <form:input path="pool" type="radio" id="yes" name="btn"
						value="yes"/> <label>No</label> <form:input path="pool" type="radio" id="no"
						name="btn" value="no"/></td>
				</tr> --%>

				
			</table>
			
			<input type="button" value="next" id="next"> 

		</div>





   <! -----------------Location page -------------------->
   
   
   	<div id="locationPage">

				<h2>Location Page</h2>
				<table cellspacing="5px" cellpadding="5%" align="center">

					<tr>
						<td><label>Location Id</label></td>
						<td><form:input path="location_id"  name="id" id="locationid"
							placeholder="Enter your Location id"/></td>
					</tr>



                  <tr>
					<td><label>Residence Type</label></td>
					<td><form:select path="residence_type" name="ds">

							<form:option value="-1" label="--Select--" />
							<form:option value="Home" label="Single-Family Home" />
							<form:option value="Condo" label="Condo" />
							<form:option value="Townhouse" label="Townhouse" />
							<form:option value="House" label="Row House" />
							<form:option value="Duplex" label="Duplex" />
							<form:option value="Apartment" label="Apartment" />

						</form:select></td>
				</tr>

					<tr>
						<td><label>Address Line-1</label></td>
						<td><form:input path="address_line_1"  name="a1" id="address1"
							placeholder="Enter your Address Line 1"/>
						</td>
					</tr>
					<tr>
						<td><label>Address Line-2</label></td>
						<td><form:input path="address_line_2" name="a2" id="address2"
							placeholder="Enter your Address Line 2"/>
						</td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><form:input path="city"  name="city" id="city"
							placeholder="Enter your City"/></td>
					</tr>

					<tr>
						<td><label>State</label></td>
						<td><form:input path="location_state"  name="state" id="state"
							placeholder="Enter your State"/></td>
					</tr>

					<tr>
						<td><label>Zip Code</label></td>
						<td><form:input path="zip_code" name="zip" id="zipcode"
							placeholder="Enter your ZIP Code"/></td>
					</tr>

					<tr>
					   <td><label>Residence Use</label></td>
					   <td><form:select path="residence_use" name="r_user">

							<form:option value="-1" label="--Select--" />
							<form:option value="Home" label="Primary" />
							<form:option value="Condo" label="Secondary" />
							<form:option value="Townhouse" label="Rental Property" />

						</form:select></td>
				
					</tr>


					<tr>
						
						<td><input type="button" value="previous" id="previous"></td>
						<input	type="submit" value="Submit" class="btn" name="">
					</tr>
					</table>
			
	</form:form>
	
	
	</div>
	
	
	
	
	</div>
	<%-- <div id="home">
	  <! --------------------------   Home Owner Entity ------------------------>
 
	  <form:form method="POST" modelAttribute="homeowner" action="homeOwner" >

		<center>
			<br> <br> <br> <br>
			<h2>Home Owner Page</h2>
			<table cellspacing="5px" cellpadding="5%" align="center">
				<tr>
					<td><label>Owner ID</label></td>
					<td><form:input path="ownerId" type="number" name="o_Id"
							id="id" placeholder="Enter your ID" /></td>
				</tr>

				<tr>
					<td><label>First Name</label></td>
					<td><form:input path="fname" type="text" name="fn" id="fname"
							placeholder="Enter your First Name" /></td>
				</tr>

				<tr>
					<td><label>Last Name</label></td>
					<td><form:input path="lname" type="text" name="ln" id="lname"
							placeholder="Enter your Last Name" /></td>
				</tr>

				<tr>
					<td><label>Enter Date of Birth</label></td>
					<td><form:input path="dob" type="date" name="dob" id="dob" /></td>
				</tr> 

				<tr>
					<td><label>Are you retired</label></td>
					<td><form:select path="retired" name="retired">
						<form:option value="Yes" label="Yes"/>
						<form:option value="No" label="No"/>
						</form:select></td>
				</tr>

				<tr>
					<td><label>Social Security number </label></td>
					<td><form:input path="socialSocietyNumber" type="number"
							name="s_no" id="SSN"
							placeholder="Enter your Social Security Number" /></td>
				</tr>

				 <tr>
					<td><label>Email Address</label></td>
					<td><form:input path="email" type="email" name="owner_email" id="emailId"
						placeholder="Enter your EmailID" /></td>
				</tr> 

				<tr>
					<td><input type="submit" value="Submit" name=""></td>
				</tr>
			</table>
		</center>

	</form:form>
	  </div>
	   --%>
	  
	  
	  
	
</body>
</html>