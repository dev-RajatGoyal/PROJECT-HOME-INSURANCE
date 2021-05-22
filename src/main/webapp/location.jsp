<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Location details</title>
</head>
<body>
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
		</center>
	</div>
</body>
</html>