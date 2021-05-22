<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User DashBoard</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
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







	<!--------------------------------- Home Owner Page --------------------------------------->
	<div id="owner">
		<div class="container">
			<div class="header">
				<h2>Owner Info FORM</h2>
			</div>
			<center>
				<form action="fname" id="fname">
					<div class="form-control">
						<label>First Name</label> <input type="text" name="" id="fname"
							placeholder="Enter your First Name" autocomplete="off"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
		</div>
		<center>
			<form action="lname" id="lname">
				<div class="form-control">
					<label>Last Name</label> <input type="text" name="" id="lname"
						placeholder="Enter your Last Name" autocomplete="off"> <i
						class="fas fa-check-circle"></i> <i
						class="fas fa-exclamation-circle"></i> <small>Error
						message</small> <br> <br>
				</div>

				<div class="form-control">
					<label>Enter Date of Birth <label> <input
							type="date" name=? id="dob"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
								message</small> <br> <br>
				</div>
				<div class="form-control">

					<label>Are you retired</label> <select>
						<option>Choose Options</option>
						<option>YES</option>
						<option>NO</option>

					</select> <i class="fas fa-check-circle"></i> <i
						class="fas fa-exclamation-circle"></i> <small>Error
						message</small> <br> <br>
				</div>


				<div class="form-control">
					<label>Social Security number </label> <input type="number" name=""
						id="SSN" placeholder="Enter your SSN" autocomplete="off">
					<i class="fas fa-check-circle"></i> <i
						class="fas fa-exclamation-circle"></i> <small>Error
						message</small> <br> <br>
				</div>

				<div class="form-control">
					<label>Email Address</label> <input type="email" name=? id=emailId
						placeholder="Enter your EmailID " autocomplete="off"> <i
						class="fas fa-check-circle"></i> <i
						class="fas fa-exclamation-circle"></i> <small>Error
						message</small> <br> <br>
				</div>

				<input type="submit" value="Submit" class="btn" name="">

			</form>

			<br>
			<button id="back">Back</button>
		</center>
	</div>

	</div>

	<!-------------------------------------- Property Page ----------------------------------------->
	<div id="propertyPage">

		<div class="container">
			<div class="header"></div>
			<center>
				<h2>PROPERTY FORM</h2>
				<form action="location" id="location">
					<div class="form-control">
						<label>Market Value</label> <input type="number" name=""
							id="property" placeholder="$" autocomplete="off"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Build Year</label> <input type="text" name=""
							id="buildyear" placeholder="Square Feet" autocomplete="off">

						<i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Dwelling Style</label> <select>
							<option>Choose Options</option>
							<option>1 Story</option>
							<option>1.5 Story</option>
							<option>2</option>
							<option>2.5 Story</option>
							<option>3</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Roof Material</label> <select>
							<option>Choose Options</option>
							<option>Concrete</option>
							<option>Clay</option>
							<option>Rubber</option>
							<option>Steel</option>
							<option>Tin</option>
							<option>Wood</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Type of Garage</label> <select>
							<option>Choose Options</option>
							<option>Attached</option>
							<option>Detached</option>
							<option>Basement</option>
							<option>Built-in</option>
							<option>None</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Numeber of Full Baths</label> <select>
							<option>Choose Options</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Number of Half Baths</label> <select>
							<option>Choose Options</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br>

					<div class="form-control">
						<label>Do you have Swimming Pool</label> <input type="radio"
							id="yes" name="yes" value="yes"> <label>Yes</label> <input
							type="radio" id="no" name="no" value="no"> <label>No</label>
						<i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<br> <input type="submit" value="Submit" class="btn" name="">

				</form>
			</center>
		</div>
	</div>










	<!--------------------------------- Location page --------------------------------------------------->
	<div id="locationPage">
		<div class="container">
			<div class="header">
				<h2>LOCATION FORM</h2>
			</div>
			<center>
				<form action="location" id="location">
					<div class="form-control">
						<label>Location Id</label> <input type="number" name=""
							id="locationid" placeholder="Enter your Location id"
							autocomplete="off"> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">

						<label>Residence Type</label> <select>
							<option>Choose Options</option>
							<option>Single-Family Home</option>
							<option>Condo</option>
							<option>Townhouse</option>
							<option>Row House</option>
							<option>Duplex</option>
							<option>Apartment</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">
						<label>Address Line-1</label> <input type="text" name=""
							id="address1" placeholder="Enter your Address Line 1"
							autocomplete="off"> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>


					<div class="form-control">
						<label>Address Line-2</label> <input type="text" name=""
							id="address2" placeholder="Enter your Address Line 2"
							autocomplete="off"> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">
						<label>City</label> <input type="text" name="" id="address2"
							placeholder="Enter your City" autocomplete="off"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">
						<label>State</label> <input type="text" name="" id="address2"
							placeholder="Enter your State" autocomplete="off"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">
						<label>Zip Code</label> <input type="text" name="" id="address2"
							placeholder="Enter your City" autocomplete="off"> <i
							class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>

					<div class="form-control">
						<label>Residence User</label> <select>
							<option>Choose Options</option>
							<option>Primary</option>
							<option>Secondary</option>
							<option>Rental Property</option>
						</select> <i class="fas fa-check-circle"></i> <i
							class="fas fa-exclamation-circle"></i> <small>Error
							message</small>
					</div>
					<input type="submit" value="Submit" class="btn" name="">

				</form>
				<br>
				<button id="back">Back</button>
			</center>

		</div>
	</div>

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
	</script>
</body>
</html>