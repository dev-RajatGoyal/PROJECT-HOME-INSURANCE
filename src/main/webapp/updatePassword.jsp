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
	<!-- 
	<script type="text/javascript" src="../abc.js">
	</script> -->
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
     
      if (role.length < 1) {
	        $('#role').after('<span class="error">This field is required</span>');
	      }   
      if (email.length < 1) {
	        $('#email').after('<span class="error">This field is required</span>');
	      }
	      
     
    });//submit
    
 
  });
</script>
<script>
    function madeAjaxCall() {
	var userid = $("#userid").val();
	var role = $("#role").val();
	var email = $("#email").val();
	if(userid.length<1)
	    return ;
	if(role.length<1)
	    return ;
	if(email.length<1)
	    return ;
	
	
	$.ajax({
	    type : "POST",
	    url : 'updatePassword',
	    data : {
		userid : userid,
		role : role,
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
				<h2>Change Password form</h2>
			</div>
			<form class="form" id="form">

				<div class="form-control">
					<label>User Id :: </label> <input type="number" name="userid"
						id="userid" placeholder="Enter your User Id" autocomplete="off">

				</div>

		<div class="form-control">
					<label>Email :: </label> <input type="text" name="email"
						id="email" placeholder="Enter your email address" >
				</div>


				<div class="form-control">
				<label>New Password :: </label> <input type="password"  name="role" id="role"
				 placeholder="Enter your new password" >
				

				</div>



				<input type="submit" value="Submit" class="btn" name=""
					onclick="madeAjaxCall()">
			</form>
		</div>
	</div>

</body>
</html>