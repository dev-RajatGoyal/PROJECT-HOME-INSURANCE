<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/UserDashboard.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
 <script src="https://kit.fontawesome.com/a076d05399.js"></script>
 </head>
<body>
	<div class="btn">
		<span class="fas fa-bars"></span>
	</div>
	
	<nav class="sidebar" >
	 <nav class="sidebar">
	
			<center class="profile">
				<img src="img/avatar.png" alt="">
				<p>User Dashboard</p>
			</center>  



			<div class="text">User Dashboard</div>

			<ul>
				<li class="active"><button>Dashboard</button></li>
				<li>
					<button class="feat-btn">
						Get Quote <span class="fas fa-caret-down first"></span>
					</button>
					<ul class="feat-show">
						<li><button id="homeownerbtn">HomeOwner Page</button></li>
						<li><button id="locationbtn">Property & Location Page</button></li>
						<li><button id="quotebtn">Quote Page</button></li>
						<li><button>Property Page</button></li>
					</ul>
				</li>
				<li>
					<button class="serv-btn">
						Retrieve Quote <span class="fas fa-caret-down second"></span>
					</button>
					<ul class="serv-show">
						<li><button>Retrieve Quote Page</button></li>
						<li><button>Quote Summary Page</button></li>
					</ul>
				</li>
				<li>
					<button class="buy-btn" id="buyPolicyBtn">
						Buy Policy <span class="fas fa-caret-down third"></span>

					</button>
					<ul class="buy-show">
						<li><button>E-Sign</button></li>
					</ul>
				</li>

				<li><button>Cancel Policy</button></li>
				<li><button>Renew Policy</button></li>
				<li><button>Log Out</button onClick="home.jsp"></li>
			</ul>
		</nav></nav>
		</div>
		      
		      
		      <!-- Image Used for background  -->
		      
		      
		      <div id="right">
            <div id="img" class="imalign">
              <img src="img/onlinecv.jpeg" alt="image" height="600">
                <img src="img/S2.png" alt="iamge" height="400">
            </div>
        </div>
	


		<! --------------------------   Home Owner Entity ------------------------>
		<div  id="homeOwnerPage" class="homestyle">
			<form:form method="POST" modelAttribute="home" action="homeowner">

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
							<td><form:input path="fname" type="text" name="fn"
									id="fname" placeholder="Enter your First Name" /></td>
						</tr>

						<tr>
							<td><label>Last Name</label></td>
							<td><form:input path="lname" type="text" name="ln"
									id="lname" placeholder="Enter your Last Name" /></td>
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
						</tr>

						<tr>
							<td><label>Social Security number </label></td>
							<td><form:input path="socialSocietyNumber" type="number"
									name="s_no" id="SSN"
									placeholder="Enter your Social Security Number" /></td>
						</tr>

						<tr>
							<td><label>Email Address</label></td>
							<td><form:input path="email" type="email" name="owner_email"
									id="emailId" placeholder="Enter your EmailID" /></td>
						</tr>

						<tr>
							<td><input type="submit" value="Submit" name=""></td>
						</tr>
					</table>
				</center>

			</form:form>
		</div>
		<div id="page" align="center" >

			<form:form method="POST" modelAttribute="location" action="location">


				<! --------------- property page --------->

				<div id="propertyPage" class="homestyle">

					<h2>Property Page</h2>
					<table cellspacing="5px" cellpadding="5%">

						<tr>
							<td><label>Property ID</label></td>
							<td><form:input path="property.property_id" name="p_Id"
									id="id" placeholder="Enter your Property ID" /></td>
						</tr>

						<tr>
							<td><label>Market Value</label></td>
							<td><form:input path="property.market_value" name="mv"
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
							<td><form:select path="property.full_baths" name="fb">
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


				<div id="locationPage" class="homestyle">

					<h2>Location Page</h2>
					<table cellspacing="5px" cellpadding="5%">

						<tr>
							<td><label>Location Id</label></td>
							<td><form:input path="location_id" name="id" id="locationid"
									placeholder="Enter your Location id" /></td>
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
							<td><form:input path="address_line_1" name="a1"
									id="address1" placeholder="Enter your Address Line 1" /></td>
						</tr>
						<tr>
							<td><label>Address Line-2</label></td>
							<td><form:input path="address_line_2" name="a2"
									id="address2" placeholder="Enter your Address Line 2" /></td>
						</tr>
						<tr>
							<td><label>City</label></td>
							<td><form:input path="city" name="city" id="city"
									placeholder="Enter your City" /></td>
						</tr>

						<tr>
							<td><label>State</label></td>
							<td><form:input path="location_state" name="state"
									id="state" placeholder="Enter your State" /></td>
						</tr>

						<tr>
							<td><label>Zip Code</label></td>
							<td><form:input path="zip_code" name="zip" id="zipcode"
									placeholder="Enter your ZIP Code" /></td>
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
							<td><input type="submit" value="Submit" name=""></td>
						</tr>
					</table>
				</div>

			</form:form>
		</div>

		<!-- --------------------------------------  Get Quote------------------------------------------------------- -->




		<div id="quote" align="center" class="homestyle">
			<table class="content-table">
				<thead>
					<tr>
						<td>Quote Id</td>
						<td>Add Living exp</td>
						<td>Deductible</td>
						<td>Detached structures</td>
						<td>Dwelling coverage</td>
						<td>Medical expense</td>
						<td>Monthly premium</td>
						<td>Personal property</td>
						<td>Location id</td>
						<td><button id="buyPolicyBtn">Buy Policy</button></td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${quote.getQuote_id()}</td>
						<td>${quote.getAdd_living_exp()}</td>
						<td>${quote.getDeductible()}</td>
						<td>${quote.getDetached_structures()}</td>
						<td>${quote.getDwelling_coverage()}</td>
						<td>${quote.getMedical_expense()}</td>
						<td>${quote.getMonthly_premium()}</td>
						<td>${quote.getPersonal_property()}</td>
						<td>${quote.getLocation_id().getLocation_id()}</td>
					</tr>
				</tbody>

			</table>
		</div>


		<div id="policyPage">
			Start Date<input type="date" /><br /> End Date<input type="date" /> <input
				type="submit" value="Buy Policy" />
		</div>

		<script>
  
		$(document).ready(function() {
			$('#page').hide();
			$('#homeOwnerPage').hide();
            $('#quote').hide();
			$('#policyPage').hide();
			$('#sidebar').show();
		
		});
		
		
		$('#homeownerbtn').click(function() {
			$('#homeOwnerPage').show();
			$('#page').hide();
			$('#quote').hide();
			$('#sidebar').hide();
			$('#right').hide();
			$('#policyPage').hide();
			$('#toptest').hide();
		});

		 $('#locationbtn').click(function() {
			$('#page').show();
			$('#propertyPage').show();
			$('#locationPage').hide();
			$('#homeOwnerPage') .hide();
			$('#quote').hide();
			$('#sidebar').hide();
			$('#right').hide();
		});
		
		 $('#previous').click(function() {
				$('#page').show();
				$('#locationPage').hide();
				$('#propertyPage').show();
				$('#homeOwnerPage').hide();
				$('#quote').hide();
				$('#sidebar').hide();
				$('#right').hide();
			});
			

		$('#next').click(function() {
			$('#page').show();
			$('#locationPage').show();
			$('#propertyPage').hide();
			$('#homeOwnerPage').hide();
			$('#quote').hide();
			$('#sidebar').hide();
			$('#right').hide();
		});
		
		
		$('#quotebtn').click(function() {
			$('#quote').show();
			$('#page').hide();
			$('#homeOwnerPage').hide();
			$('#policyPage').hide();
			$('#sidebar').hide();
			$('#right').hide();
		});
			
		
		$('#buyPolicyBtn').click(function() {
			$('#quote').hide();
			$('#policyPage').show();
			$('#right').hide();
		});
		
		
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