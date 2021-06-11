<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Summary Page</title>
</head>
<body>

   <!-- ---------------------------- Summary Page for Home Owner--------------------------------------------->
		
		<div id="ownerPage" align="center" class="homestyle">
			<table class="content-table">
				<thead>
				<h3>Home Owner Details</h3>
					<tr>
						<td>Owner Id</td>
						<td>Owner First Name</td>
						<td>Owner Last Name</td>
						<td>Email</td>
						<td>Retired</td>
						<td>Security Number</td>
						<td>User id</td>
						
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${ownerPage.getOwnerId()}</td>
						<td>${ownerPage.getFname()}</td>
						<td>${ownerPage.getLname()}</td>
						<td>${ownerPage.getEmail()}</td>
						<td>${ownerPage.getRetired()}</td>
						<td>${ownerPage.getSocialSocietyNumber()}</td>
						<td>${ownerPage.getUser().getuserid()}</td>
						
					</tr>
				</tbody>

			</table>
		</div>
		
		<!-------------------------------------------Summary page for Property Page  ------------------------------------>
			
			
			<div id="summary1" align="center" class="homestyle">
			<table class="content-table">
				<thead>
				<h3>Property Details</h3>
					<tr>
						<td>Property Id</td>
						<td>Market Value</td>
						<td>Build Year</td>
						<td>Square Footage</td>
						<td>Dwelling Style</td>
						<td>Roof Material</td>
						<td>Type of Garage</td>
						<td>No of Full Baths</td>
						<td>No of Half Baths</td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${summary2.getProperty().getProperty_id()}</td>
						<td>${summary2.getProperty().getMarket_value()}</td>
						<td>${summary2.getProperty().getYear_built() }</td>
						<td>${summary2.getProperty().getSquare_footage()}</td>
						<td>${summary2.getProperty().getDwelling_type()}</td>
						<td>${summary2.getProperty().getRoof_material()}</td>
						<td>${summary2.getProperty().getGarage_type()}</td>
						<td>${summary2.getProperty().getFull_baths()}</td>
						<td>${summary2.getProperty().getHalf_baths()}</td>
					</tr>
				</tbody>

			</table>
		</div>
			  
			  
		<!-------------------------------------------Summary page for Location Page  ------------------------------------>
			
			
			<div id="summary2" align="center" class="homestyle">
			<table class="content-table">
				<thead>
				<h3>Location Details</h3>
					<tr>
						<td>Location Id</td>
						<td>Residence Type</td>
						<td>Address Line-1</td>
						<td>Address Line-2</td>
						<td>City</td>
						<td>State</td>
						<td>Zip Code</td>
						<td>Residence Use</td>
						<td>Property Id</td>
						<td>Location Id</td>
						
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${summary2.getLocation_id()}</td>
						<td>${summary2.getResidence_type()}</td>
						<td>${summary2.getAddress_line_1()}</td>
						<td>${summary2.getAddress_line_2()}</td>
						<td>${summary2.getCity()}</td>
						<td>${summary2.getLocation_state()}</td>
						<td>${summary2.getZip_code()}</td>
						<td>${summary2.getResidence_use()}</td>
						<td>${summary2.getProperty().getProperty_id()}</td>
						<td>${summary2.getUser().getuserid()}</td>
						
					</tr>
				</tbody>

			</table>
		</div>
			
		<!-------------------------------------------Summary page for Quote Page  ------------------------------------>
			
		
			<div id="summary3" align="center" class="homestyle">
			<table class="content-table">
				<thead>
				<h3>Quote Details</h3>
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
						
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${quotes.getQuote_id()}</td>
						<td>${quotes.getAdd_living_exp()}</td>
						<td>${quotes.getDeductible()}</td>
						<td>${quotes.getDetached_structures()}</td>
						<td>${quotes.getDwelling_coverage()}</td>
						<td>${quotes.getMedical_expense()}</td>
						<td>${quotes.getMonthly_premium()}</td>
						<td>${quotes.getPersonal_property()}</td>
						<td>${quotes.getLocation_id().getLocation_id()}</td>
					</tr>
				</tbody>

			</table>
		</div>

</body>
</html>