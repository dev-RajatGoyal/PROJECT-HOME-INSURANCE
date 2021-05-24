<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>






	<div id="dashboard">
		<h1>
			Hello <br> ${user.username} <br> Welcome to user dashboard

		</h1>
		<button id="ownerBTN">Add HomeOwner details</button>
		<br>
		<button id="location">Add Location details</button>
	</div>






	<form  action="location" >



		<!--  -------------------- Location Page ------------------------------- -->


		<div id="locationPage">


			<center>
				<br> <br> <br> <br>
				<h2>Location Page</h2>
				<table cellspacing="5px" cellpadding="5%" align="center">

					<tr>
						<td><label>Location Id</label></td>
						<td><input type="number" name="id" id="locationid"
							placeholder="Enter your Location id"></td>
					</tr>

					<tr>
						<td><label>Residence Type</label></td>
						<td><select name="rt">
								<option>Choose Options</option>
								<option>Single-Family Home</option>
								<option>Condo</option>
								<option>Townhouse</option>
								<option>Row House</option>
								<option>Duplex</option>
								<option>Apartment</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Address Line-1</label></td>
						<td><input type="text" name="a1" id="address1"
							placeholder="Enter your Address Line 1">
						</td>
					</tr>
					<tr>
						<td><label>Address Line-2</label></td>
						<td><input type="text" name="a2" id="address2"
							placeholder="Enter your Address Line 2">
						</td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><input type="text" name="city" id="city"
							placeholder="Enter your City"></td>
					</tr>

					<tr>
						<td><label>State</label></td>
						<td><input type="text" name="state" id="state"
							placeholder="Enter your State"></td>
					</tr>

					<tr>
						<td><label>Zip Code</label></td>
						<td><input type="number" name="zip" id="zipcode"
							placeholder="Enter your ZIP Code"></td>
					</tr>

					<tr>
						<td><label>Residence User</label></td>
						<td><select name="r_user">
								<option>Choose Options</option>
								<option>Primary</option>
								<option>Secondary</option>
								<option>Rental Property</option>
						</select></td>
					</tr>


					<tr>
						
						<td><input type="button" value="Next" id="next"></td>
					</tr>
					</table>
					</center>

					</div>





					<! -------------------------------- Property Page -------------------------------->


					<div id="propertyPage">
						<center>
							<br>
							<br>
							<br>
							<br>
							<h2>Property Page</h2>
							<table cellspacing="5px" cellpadding="5%" align="center">

								<tr>
									<td><label>Property ID</label></td>
									<td><input type="number" name="p_Id" id="id"
										placeholder="Enter your Property ID"></td>
								</tr>

								<tr>
									<td><label>Market Value</label></td>
									<td><input type="number" name="mv" id="property"
										placeholder="$"></td>
								</tr>

								<tr>
									<td><label>Build Year</label></td>
									<td><input type="text" name="by" id="buildyear"
										placeholder="Square Feet">
									</td>
								</tr>
								<tr>
									<td><label>Dwelling Style</label></td>
									<td><select name="ds">
											<option>Choose Options</option>
											<option>1 Story</option>
											<option>1.5 Story</option>
											<option>2</option>
											<option>2.5 Story</option>
											<option>3</option>
									</select></td>
								</tr>

								<tr>
									<td><label>Roof Material</label></td>
									<td><select name="rm">
											<option>Choose Options</option>
											<option>Concrete</option>
											<option>Clay</option>
											<option>Rubber</option>
											<option>Steel</option>
											<option>Tin</option>
											<option>Wood</option>
									</select></td>
								</tr>

								<tr>
									<td><label>Type of Garage</label></td>
									<td><select name="tg">
											<option>Choose Options</option>
											<option>Attached</option>
											<option>Detached</option>
											<option>Basement</option>
											<option>Built-in</option>
											<option>None</option>
									</select></td>
								</tr>

								<tr>
									<td><label>Numeber of Full Baths</label></td>
									<td><select name="fb">
											<option>Choose Options</option>
											<option>1</option>
											<option>2</option>
											<option>3</option>
									</select></td>
								</tr>

								<tr>
									<td><label>Numeber of Half Baths</label></td>
									<td><select name="hb">
											<option>Choose Options</option>
											<option>1</option>
											<option>2</option>
											<option>3</option>
									</select></td>
								</tr>

								<tr>
									<td><label>Do you have Swimming Pool</label></td>
									<td><label>Yes</label> <input type="radio" id="yes"
										name="btn" value="yes"> <label>No</label> <input
										type="radio" id="no" name="btn" value="no"></td>
								</tr>

								<tr>
								</tr>
								</table>
								<td><input type="button" value="Previous" id="previous"></td>
								<input type="submit" value="Submit" class="btn" name="">
								</center>
								</div>
	</form>




	<script>
		$(document).ready(function() {
			$('#owner').hide();
			$('#locationPage').hide();
			$('#propertyPage').hide();
			$('#dashboard').show();
		});

		$('#ownerBTN').click(function() {
			$('#dashboard').hide();
			$('#owner').show();
			$('#locationPage').hide();
			$('#propertyPage').hide();
		});

		$('#location').click(function() {
			$('#dashboard').hide();
			$('#owner').hide();
			$('#locationPage').show();
			$('#propertyPage').hide();
		});
		
		$('#location').click(function() {
			$('#dashboard').hide();
			$('#owner').hide();
			$('#locationPage').show();
			$('#propertyPage').hide();
		});

		$('#back').click(function() {
			$('#dashboard').hide();
			$('#owner').hide();
			$('#locationPage').show();
			$('#propertyPage').hide();
		});
		
		
		
		$('#next').click(function() {
			$('#dashboard').hide();
			$('#owner').hide();
			$('#locationPage').hide();
			$('#propertyPage').show();
		});
		
		
		
		$('#previous').click(function() {
			$('#dashboard').hide();
			$('#owner').hide();
			$('#locationPage').show();
			$('#propertyPage').hide();
		});
	</script>



</body>
</html>