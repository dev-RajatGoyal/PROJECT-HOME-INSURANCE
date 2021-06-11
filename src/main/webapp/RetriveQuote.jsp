<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrive Quote Page</title>
<link rel="stylesheet" href="css/viewpage.css">
</head>
<body>
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

</body>
</html>