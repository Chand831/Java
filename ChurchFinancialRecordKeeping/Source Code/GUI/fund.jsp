<!-- 
	This page is used to add the fund,update the fund,delete the fund and display 
	all the funds in the application.
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%
	HashMap<Integer, String> fundMap = (HashMap<Integer, String>) session.getAttribute("fundMap");	
%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>Fund</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
/*space*/
body>#pagediv form .field_container {
	margin: 0 auto 12px;
	text-align: left;
	width: auto;
}
/*field_container*/
body>#pagediv form .field_container {
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

label {
	display: inline-block;
	text-align: left;
	width: 100px;
}
/*form box*/
body>#pagediv form {
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
	left: 25%;
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

.tb_label {
	height: 64px;
	border: 1px solid #f5ab36;
	margin-right: 10px;
	font-family: "Arial black", Gadget, sans-serif;
	color: #000;
	text-decoration: none;
	padding: 10px;
	text-align: center;
	background-color: #ffd89b;
}

body>#pagediv form button .button_text {
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

body>#line {
	border-top: 8px solid #f90;
	width: 100%;
}

ul#tabnavigation {
	list-style: none;
	position: relative;
	z-index: 2;
	top: 1px;
	display: table;
	border-left: 0px solid #f5ab36;
}

ul#tabnavigation li {
	float: left;
}

ul#tabnavigation li a {
	background: #ffd89b;
	color: #222;
	display: block;
	padding: 6px 15px;
	text-decoration: none;
	float: left;
	width: 75px;
	text-align: center;
	border-right: 1px solid #f5ab36;
	border-top: 1px solid #f5ab36;
	margin-right: 8px;
	font-family: "Arial Black", Gadget, sans-serif;
}

ul#tabnavigation li a:hover {
	background: #344385;
	color: #fff;
	text-shadow: 1px 1px 1px #000;
}

ul#tabnavgation li a.selected {
	border-bottom: 1px solid #fff;
	color: #344385;
	background: #fff;
}

#etable {
	margin: 0px auto;
	font-family: Tahoma, Arial, Verdana, sans-serif;
	font-size: 13px;
	padding: 4px;
	cellpadding: 0;
	cellspacing: 0
}

.head {
	background: lightseagreen;
}

#etable tr td {
	padding: 8px;
	border: 1px solid #d1d1d1;
}

.head td {
	border: 0px !important;
}

input[type='text'] {
	padding: 3px 3px;
	width: 187px;
}

.hightlight {
	border: 1px solid #9F1319;
	background: url(img/iconCaution.gif) no-repeat 2px !important;
}
</style>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" />
</head>
<body>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	<!-- <script type="text/javascript" src="scripts/prototype.js"></script> -->
	<script>
		$(function() {
			$('#etable').DataTable();
		});
	</script>
	<script type="text/javascript">
		var request;
		
		function LoadOnce() {
			window.location.reload();
		}
		
		function onShowTab(index) {
			var numberTabs = 2;
			for (var i = 1; i < (numberTabs + 1); i++) {

				var tabTitle = document.getElementById('tab-title-' + i);
				tabTitle.style.backgroundColor = "";
				tabTitle.style.borderBottom = "";

				var tabSheet = document.getElementById('tab-sheet-' + i);
				tabSheet.style.display = "none";
			}

			var tabTitle = document.getElementById('tab-title-' + index);
			//tabTitle.style.backgroundColor = "#E1F5A9";
			tabTitle.style.borderBottom = "0px";

			var tabSheet = document.getElementById('tab-sheet-' + index);
			tabSheet.style.display = "block";
		}
		
		function getRequest() {				
			if (window.ActiveXObject) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else
				return null;
		}
		
		function addFund() {
			request = getRequest();			
			var url = "addFund?fundNo=" + encodeURIComponent(document.getElementById("fundNo").value) + "&fundName=" + encodeURIComponent(document.getElementById("fundName").value);
			//alert(url);			
			request.onreadystatechange = responseReadyState;
			request.open("GET",url, true);			
			request.send(null);
		}
		
		function responseReadyState() {			
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Fund Added Successfully.");
					//LoadOnce();					
				}
			}
		}
		
		/* function updateFund(fundNo,fundName){
			alert(fundNo);
			var url = "updateFund";
			alert(fundName);
			var ajaxReq = new Ajax.Request(
					url,{
						method:'POST',
						parameters:{fundNumber:$F('5'),fundingName:$F('ram')},
						onSuccess:function(transport){alert("Fund Updated Successfully");}});
		} */
		
		function updateFund(fundNo,fundName){
			request = getRequest();
			url = "updateFund?fundNo=" + encodeURIComponent(fundNo) + "&fundName=" + encodeURIComponent(fundName);
			request.onreadystatechange = responseReadyStateForUpdate;
			request.open("GET", url, true);
			request.send(null);
		}
		
		function responseReadyStateForUpdate() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Fund updated successfully");
				}
			}
		}
		
		function deleteFund(fundNo){
			request = getRequest();
			url = "deleteFund?fundNo=" + encodeURIComponent(fundNo);
			request.onreadystatechange = responseReadyStateForDelete;
			request.open("GET", url, true);
			request.send(null);
		}
		
		function responseReadyStateForDelete() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Fund Deleted successfully");
					LoadOnce();
				}
			}
		}		
		
		function logout() {
			//window.location = "login.html";
			request = getRequest();
			url = "logout";	
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						alert(" Logged out successfully");	
						window.location = "login.jsp";
					}
				}
			};
			request.open("GET", url, true);
			request.send(null);
		}
	</script>
	
	<h1 align="center">CHURCH FINANCIAL RECORD KEEPING</h1>
	<div id="line"></div>
	<div align="right">
		<!-- <button type="submit" onclick="logout()">
			<span class="button_text">Logout</span>
		</button> -->
		<input type="button" class="button_text" value="Logout"
			onclick="logout()">
	</div>
	<ul id="tabnavigation">
		<li><a class="selected" href="memberPage">Member</a></li>
		<li><a href="fundPage">Fund</a></li>
		<li><a href="donationPage">Donation</a></li>
		<li><a href="reportPage">Report</a></li>
	</ul>

	<div id="pagediv">
		<form id="page_form">
		<div id="img" align="right">
			<img src="./images/church.png" align="right" alt="Mountain View" style="width:75px;height:75px;">
		</div>
			<table width="100%">
				<tbody>
					<tr>
						<td>
							<table>
								<tbody>

									<tr>

										<td id="tab-title-1" style="border-bottom: 0px;"><a
											href="#" class="tb_label" onclick="onShowTab(1)">Add</a></td>

										<td id="tab-title-2"><a href="#" class="tb_label"
											onclick="onShowTab(2)">View</a></td>
									</tr>
									<tr>
										<td style="height: 0.5em;">&#160;</td>
									</tr>
									<tr>
										<td style="height: 0.5em;">&#160;</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<div id="tab-sheet-1" style="display: block;">
								<label>Fund Number</label>
								<div class="field_container">
									<input type="text" id="fundNo" name="fundNo" pattern="[1-9]{1}[0-9]{0,2}"
										title="It should be a number" style="width: 150px; border: 1px" required/>
								</div>
								<br /> <label>Fund Name</label>
								<div class="field_container">
									<input type="text" id="fundName" name="fundName" pattern="[A-Za-z ]{1,32}"
										title="Please enter valid fund name" style="width: 150px; border: 1px" required/>
								</div>
								<br />

								<div align="right">
									<!-- <button onclick="addFund()">
										<span class="button_text">Add Fund</span>
									</button> -->
									<button type="submit" form="page_form" formmethod="post" formaction="addFund">
										<span class="button_text">Add Fund</span>
									</button>
									&nbsp;&nbsp;
									<button type="reset">
										<span class="button_text">Reset</span>
									</button>
								</div>
							</div>
							<div id="tab-sheet-2" style="display: none;" class="tf_sheet">

								<table id="etable" cellspacing="0">

									<thead>
										<tr class="head">
											<th>Fund Number</th>
											<th>Fund Name</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<% for (Map.Entry<Integer, String> entry : fundMap.entrySet()) { %>
										<tr>
											<td id='<%=entry.getKey() %>' contenteditable="true"><%=entry.getKey() %></td>

											<td id='<%=entry.getValue() %>' contenteditable="true"><%=entry.getValue() %></td>

											<td><input type="button" class="ajaxedit" value="Update" onclick="updateFund(getElementById('<%=entry.getKey() %>').innerHTML,getElementById('<%=entry.getValue() %>').innerHTML)">
												<input type="button" class="ajaxdelete" value="Delete" onclick="deleteFund(getElementById('<%=entry.getKey() %>').innerHTML)">
											</td>
										</tr>										
										<%} %>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td style="height: 0.5em;">&#160;</td>
					</tr>
					<tr>
					</tr>
				</tbody>
			</table>
		</form>

	</div>
	<div>
		<p align="center">&copy; Mission Impossible IV 2016</p>
	</div>
</body>
</html>
