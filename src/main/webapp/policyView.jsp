<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="quote" align="center" >
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
</body>
</html>