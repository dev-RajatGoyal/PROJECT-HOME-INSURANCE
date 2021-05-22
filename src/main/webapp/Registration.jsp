<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewpoint" content="width=device-width",initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="css/regstyle.css">
</head>
<body>
	<div class="container">
	<div class="header">
		<h2>REGISTRATION FORM</h2>
	</div>
	<form class="form" id="form" action="registersuccess" method="post">
		
		<div class="form-control">
			<label>User Id</label>
			<input type="number" name="userid" id="username" placeholder="Enter your User Id" autocomplete="off">
			<i class="fas fa-check-circle"></i>
			<i class="fas fa-exclamation-circle"></i>
			<small>Error message</small>
		</div>
		
		<div class="form-control">
			<label>Username</label>
			<input type="text" name="username" id="username" placeholder="Enter your Username" autocomplete="off">
			<i class="fas fa-check-circle"></i>
			<i class="fas fa-exclamation-circle"></i>
			<small>Error message</small>
		</div>

		<div class="form-control">
			<label>Role</label><br>
			<select name="role">
				<option>User</option>
				<option>Admin</option>
			</select>
			<i class="fas fa-check-circle"></i>
			<i class="fas fa-exclamation-circle"></i>
			<small>Error message</small>
		</div>

		
		<div class="form-control">
			<label>Password</label>
			<input type="password" name="password" id="password" placeholder="Enter your Password" autocomplete="off">
			<i class="fas fa-check-circle"></i>
			<i class="fas fa-exclamation-circle"></i>
			<small>Error message</small>
		</div>
		<div class="form-control">
			<label>Confirm Password</label>
			<input type="password" name="cpassword" id="cpassword" placeholder="Enter your Password again" autocomplete="off">
			<i class="fas fa-check-circle"></i>
			<i class="fas fa-exclamation-circle"></i>
			<small>Error message</small>
		</div>
		<input type="submit" value="Submit" class="btn" name="">
	</form>
</div>
<script type="text/javascript">
	const form=document.getElementById('form');
	const usernameVal=document.getElementById('username');
	const passwordVal=document.getElementById('password');
	const cpasswordVal=document.getElementById('cpassword');

	//add event

	form.addEventListener('submit', (event) =>{
		event.preventDefault();
		validate();//call function
		// => fatarrow function
	})

	
	//define the validate function
	const validate = () => {
	const username=username.value.trim();
	const password=password.value.trim();
	const cpassword=cpassword.value.trim();
	

	//name validation
	if(usernameVal === ""){
		setErrorMsg(username,'name can not be blank');
	}else if(username.length <= 2){
		setErrorMsg(username,'name minimum 3 character');
	}else{
		setSuccessMsg(username);
	}

	//password validation
	if(passwordVal === ""){
		setErrorMsg(password,'password can not be null');
	}else if(passwordVal.length <= 5){
		setErrorMsg(password,'Minimum 6 character');
	}else{
		setSuccessMsg(password);
	}

	//confirm password validation
	if(cpasswordVal === ""){
		setErrorMsg(cpassword,'confirm password can not be null');
	}else if(passwordVal != cpasswordVal){
		setErrorMsg(cpassword,'password does not match');
	}else{
		setSuccessMsg(cpassword);
	}
}

	function setErrorMsg(input, errormsgs){
		const formControl = input.parentElement;
		const small = formControl.querySelector('small');
		form-control.className = "form-control error";
		small.innerText = errormsgs;
	}

	function setErrorMsg(input){
		const formControl = input.parentElement;
		form-control.className = "form-control success";
		
	}
	

 	</script>
</body>
</html>