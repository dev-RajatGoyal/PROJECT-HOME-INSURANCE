<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send OTP :: </title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/regstyle.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script>

$(document).ready(function() {

    $('#form').submit(function(e) {
      e.preventDefault();
      var otp = $("#otp").val();
	var password = $("#password").val();
	var cpassword = $("#cpassword").val();

      $(".error").remove();
      if (otp.length < 1) {
	        $('#otp').after('<span class="error">This field is required</span>');
	      }
     if (password.length < 8) {
	        $('#password').after('<span class="error">Password must be at least 8 characters long</span>');
	      }
     
    });//submit
    
 
  });
</script>
<script>
    function madeAjaxCall() {
	var otp = $("#otp").val();
	var password = $("#password").val();
	if(otp.length<1)
	    return ;
	
	if(password.length<1)
	    return ;
	
	$.ajax({
	    type : "POST",
	    url : 'submitotp',
	    data : {
		otp : otp,
		password : password,
		},
	    cache : false,
	    success : function(response) {
		$('#somediv').html(response);
		$('#div2').hide();
	    },
	    error : function() {
		$('#div2').html(response);
		$('#div1').hide();
	    }
	});
   }
</script>
</head>
<body>
<div class="container">
			<div id="div">
			<div style="color: red; text-align: center;">
				<h1 id="somediv"></h1>
			</div>
		</div>

<div id="div22">

			<div class="header">
				<h2>Change Password form</h2>
			</div>
	<form class="form" id="form">

		<div class="form-control">
			<label>Enter Your OTP :: </label> <input type="number" name="otp"
				id="otp" placeholder="Enter your otp" autocomplete="off">
		</div>
		<div class="form-control">
			<label>Password</label> <input type="password" name="password"
				id="password" placeholder="Enter your Password" autocomplete="off">

		</div>
		
		<input type="button" value="Submit" class="btn" name=""
					onclick="madeAjaxCall()">
	</form>
	</div>
</div>
</body>
</html>