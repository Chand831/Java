<!-- 
	This page is used to create login page 
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css">
<style>
/*space*/
body>#login form .field_container {
	margin: 0 auto 12px;
	text-align: left;
	width: auto;
}
/* line*/
body>#login {
	border-top: 8px solid #f90;
	margin: 0 auto;
	padding: 30px 0 0;
	width: 100%;
}
/*field_container*/
body>#login form .field_container {
	margin: 0 auto 12px;
	text-align: left;
	width: auto;
	box-shadow: 0 0 8px #CCC;
	-moz-box-shadow: 0 0 8px #CCC;
	-webkit-box-shadow: 0 0 8px #CCC;
	display: inline-block;
	font-size: 18px;
	height: 46px;
	cursor: pointer;
	line-height: 46px;
	padding: 0 25px;
}

/*form box*/
body>#login form {
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-wekbit-box-sizing: border-box;
	border: 8px solid #F5F3F0;
	display: inline-block;
	margin: 40px auto 0;
	padding: 100px 160px 50px;
	position: relative;
	left: 30%;
	z-index: 0;
}
/*shade button and size*/
button {
	margin: 0;
	padding: 0;
	border: 0;
	font-weight: normal;
	font-style: normal;
	font-size: 100%;
	line-height: 1;
	font-family: inherit;
	right: 0px;
}

body>#login form button .button_text {
	border-radius: 7px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	box-shadow: 0 0 8px #CCC;
	-moz-box-shadow: 0 0 8px #CCC;
	-webkit-box-shadow: 0 0 8px #CCC;
	background-color: #f6f6f6;
	background-repeat: repeat-x;
	color: black;
	display: inline-block;
	font-size: 16px;
	height: 46px;
	cursor: pointer;
	line-height: 46px;
	padding: 0 25px;
	text-shadow: 1px 1px 0 #fff;
	width: auto;
}
</style>
</head>
<body bgcolor>
	<script type="text/javascript">
		var request;
		
		function getRequest() {			
			if (window.ActiveXObject) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else
				return null;
		}
		
		function getPassword(){
			request = getRequest();
			 var email = prompt("Please enter your Email");
			 if(email != ""){
				 var url = "getPassword?email=" + encodeURIComponent(email);
				 request.onreadystatechange = responseReadyState;
				 request.open("GET",url, true);			
				 request.send(null);
			 }
			 else{
				 alert("Please enter vaild Email");
			 }
		}
		function responseReadyState() {			
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Password sent to Email.");									
				}
			}
		}
	</script>
	<h1 align="center">CHURCH FINANCIAL RECORD KEEPING</h1>
	<div id="login">
	<div id="img" align="right">
				<img src="./images/church.png" align="right" alt="Mountain View"
					style="width: 200px; height: 200px;">
			</div>
		<form id="login_form" align="center" action="login" method="POST">
			
			<div class="field_container">
				<input type="text" placeholder="User Name" name="username"
					style="border: 1px" required>
			</div>
			<br /> <br />
			<div class="field_container">
				<input type="Password" placeholder="Password" name="password"
					style="border: 1px" required>
			</div>
			<br />
			<div>
				<!-- <input name="user[remember_me]" type="hidden" value="0"> <input
					id="user_remember_me" name="user[remember_me]" type="checkbox"
					value="1"> <label class="login_link" for="user_remember_me"
					id="remember_me_label">stay signed in</label> <br /> <br /> -->
					<br/>
				<div align="right">
					<!-- <input type="submit" value="Sign In"> -->
					<button type="submit">
						<span class="button_text">Sign In</span>
					</button>
				</div>
			</div>
		
		<h6 align="center">
			Need <a href="#" onclick="getPassword()">Help</a> with your password?
		</h6>		
	</form>
	</div>	
		<div>
			<p align="center">&copy; Mission Impossible IV 2016<p>
		</div>
</body>
</html>

