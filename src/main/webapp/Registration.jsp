<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewpoint" content="width=device-width" ,initial-scale=1.0">
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/regstyle.css">


<style type="text/css">
.error {
	color: red;
	margin-left: 5px;
}
</style>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script type="text/javascript" src="../abc.js">
	</script>
<script>

$(document).ready(function() {

    $('#form').submit(function(e) {
      e.preventDefault();
      var userid = $("#userid").val();
	var username = $("#username").val();
	var role = $("#role").val();
	var password = $("#password").val();
	var cpassword = $("#cpassword").val();
	var email = $("#email").val();

      $(".error").remove();
      if (userid.length < 1) {
	        $('#userid').after('<span class="error">This field is required</span>');
	      }
      if (username.length < 1) {
	        $('#username').after('<span class="error">This field is required</span>');
	      }
      if (role.length < 1) {
	        $('#role').after('<span class="error">This field is required</span>');
	      }   
      if (email.length < 1) {
	        $('#email').after('<span class="error">This field is required</span>');
	      }
	      
      if (password.length < 8) {
	        $('#password').after('<span class="error">Password must be at least 8 characters long</span>');
	      }
      if (cpassword.length < 8) {
	        $('#cpassword').after('<span class="error">Password must be at least 8 characters long</span>');
	      }
    });//submit
    
 
  });
</script>
<script>
    function madeAjaxCall() {
	var userid = $("#userid").val();
	var username = $("#username").val();
	var role = $("#role").val();
	var password = $("#password").val();
	var cpassword = $("#cpassword").val();
	var email = $("#email").val();
	if(userid.length<1)
	    return ;
	if(username.length<1)
	    return ;
	if(email.length<1)
	    return ;
	
	
	if(password.length<1)
	    return ;
	if(cpassword.length<1)
	    return ;
	if(password!=cpassword){
	    alert("password must be same");
	    return ;
	}
	$.ajax({
	    type : "POST",
	    url : 'registersuccess',
	    data : {
		userid : userid,
		username : username,
		role : role,
		password : password,
		cpassword : cpassword,
		email : email
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
			<div id="div1">
			<div style="color: red; text-align: center;">
				<h1 id="somediv"></h1>
			</div>
		</div>

		<div id="div2">

			<div class="header">
				<h2>REGISTRATION FORM</h2>
			</div>
			<form class="form" id="form">

				<div class="form-control">
					<label>User Id :: </label> <input type="number" name="userid"
						id="userid" placeholder="Enter your User Id" autocomplete="off">

				</div>

				<div class="form-control">
					<label>User name :: </label> <input type="text" name="username"
						id="username" placeholder="Enter your Username" autocomplete="off">
				</div>
				<!-- <div class="form-control">
					<label>Role :: </label><br> <select name="role" id="role">
						<option value="User">User</option>
						<option value="Admin">Admin</option>
					</select>

				</div> -->


		<div class="form-control">
					<label>Email :: </label> <input type="text" name="email"
						id="email" placeholder="Enter your email address" >
				</div>


				<div class="form-control">
					<label>Password</label> <input type="password" name="password"
						id="password" placeholder="Enter your Password" autocomplete="off">

				</div>
				<div class="form-control">
					<label>Confirm Password</label> <input type="password"
						name="cpassword" id="cpassword"
						placeholder="Enter your Password again" autocomplete="off">				</div>
				<input type="submit" value="Submit" class="btn" name=""
					onclick="madeAjaxCall()">
			</form>
		</div>
	</div>

</body>
</html>