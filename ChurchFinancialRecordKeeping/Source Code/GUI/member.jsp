<!-- 
	This page is used to add the member,update the member,delete the member and display 
	all the members in the application.
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>

<%@ page import="church.finance.Member"%>
<%
	//HashMap<Integer, String> issues = (HashMap<Integer, String>) session.getAttribute("issues");
	ArrayList<Member> memberList = (ArrayList<Member>) session.getAttribute("memberList");
	//String designation = (String)session.getAttribute("designation");
%>

<html>
<head>
<title>Member</title>
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
	width: 100%;
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
	border-right: 1px solid #f5ab36;
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

		function getRequest() {
			//alert("Request");
			if (window.ActiveXObject) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else
				return null;
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

		function addMember() {
			request = getRequest();

			request.onreadystatechange = responseReadyStateForAdd;

			/* request.onreadystatechange = function() {
				if (request.readyState == 4) {
					alert("Member Added successfully");
					LoadOnce();
				}
			}; */
			request.open("POST", "addMember", true);
			request.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			request.send("envelopeNo="
					+ document.getElementById("envelopeNo").value
					+ "&firstName="
					+ document.getElementById("firstName").value + "&lastName="
					+ document.getElementById("lastName").value
					+ "&middleName="
					+ document.getElementById("middleName").value
					+ "&address1=" + document.getElementById("address1").value
					+ "&address2=" + document.getElementById("address2").value
					+ "&city=" + document.getElementById("city").value
					+ "&state=" + document.getElementById("state").value
					+ "&country=" + document.getElementById("country").value
					+ "&zipcode=" + document.getElementById("zipcode").value
					+ "&mobile=" + document.getElementById("mobile").value
					+ "&email=" + document.getElementById("email").value);
		}

		function responseReadyStateForAdd() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Member Added successfully");
				}
			}
		}

		function updateMember(envelopeNo, name, address1, address2, city,
				state, country, zipcode, mobile) {
			//alert(envelopeNo + "," + name + "," + address1 + "," + address2 + "," + city + "," + state + "," + country + "," + zipcode + "," + mobile);
			request = getRequest();
			url = "memberUpdate?envelopeNo=" + encodeURIComponent(envelopeNo)
					+ "&name=" + encodeURIComponent(name) + "&address1="
					+ encodeURIComponent(address1) + "&address2="
					+ encodeURIComponent(address2) + "&city="
					+ encodeURIComponent(city) + "&state="
					+ encodeURIComponent(state) + "&country="
					+ encodeURIComponent(country) + "&zipcode="
					+ encodeURIComponent(zipcode) + "&mobile="
					+ encodeURIComponent(mobile);
			//alert(url);
			request.onreadystatechange = responseReadyStateForUpdate;
			request.open("GET", url, true);
			request.send(null);
		}

		function responseReadyStateForUpdate() {
			//alert("Call");
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Member updated successfully");
					LoadOnce();
				}
			}
		}

		function deleteMember(envelopeNo) {
			request = getRequest();
			url = "memberDelete?envelopeNo=" + encodeURIComponent(envelopeNo);
			request.onreadystatechange = responseReadyStateForDelete;
			request.open("GET", url, true);
			request.send(null);
		}

		function responseReadyStateForDelete() {
			//alert("Call");
			if (request.readyState == 4) {
				if (request.status == 200) {
					alert("Member Deleted successfully");
					LoadOnce();
				}
			}
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
		<form id="page_form" method="POST">
			<div id="img" align="right">
				<img src="./images/church.png" align="right" alt="Mountain View"
					style="width: 75px; height: 75px;">
			</div>
			<table width="100%">
				<tbody>
					<tr>
						<td>
							<table>
								<tbody>
									<tr>
										<td id="tab-title-1" style="border-bottom: 0px;"><a
											href="#" class="tb_label"
											style="font-weight: bold; text-decoration: none;"
											onclick="onShowTab(1)">Add</a></td>

										<td id="tab-title-2"><a href="#" class="tb_label"
											style="font-weight: bold; text-decoration: none;"
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
								<label>Envelope No.</label>
								<div class="field_container" align="left">
									<input type="text" id="envelopeNo" name="envelopeNo"
										pattern="[1-9]{1}[0-9]{0,2}"
										title="It should be a 3 digit number"
										style="width: 150px; border: 1px" required />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>First
									Name</label>
								<div class="field_container" align="right">
									<input type="text" id="firstName" name="firstName"
										pattern="[A-Za-z ]{1,16}"
										title="Please enter valid name with length 1 to 16 characters"
										style="width: 150px; border: 1px" required />
								</div>
								<br /> <label>Last Name</label>
								<div class="field_container" align="left">

									<input type="text" id="lastName" name="lastName"
										pattern="[A-Za-z ]{1,16}"
										title="Please enter valid name with length 1 to 16 characters"
										style="width: 150px; border: 1px" required />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>Middle
									Name</label>
								<div class="field_container" align="right">

									<input type="text" id="middleName" name="middleName"
										pattern="[A-Za-z ]{16}"
										title="Please enter valid name with length 1 to 16 characters"
										style="width: 150px; border: 1px" />
								</div>
								<br /> <label>Mobile</label>
								<div class="field_container" align="left">

									<input type="text" id="mobile" name="mobile"
										pattern="[1-9]{1}[0-9]{9}"
										title="Please enter valid 10-digit mobile number"
										style="width: 150px; border: 1px" />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>E-Mail</label>
								<div class="field_container" align="right">

									<input type="text" id="email" name="email"
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
										title="Please enter valid email id"
										style="width: 150px; border: 1px" />
								</div>
								<br /> <label>Address Line1</label>
								<div class="field_container" align="left">

									<input type="text" id="address1" name="address1"
										pattern="[0-9A-Za-z ]{1,32}"
										title="Please enter valid Address"
										style="width: 150px; border: 1px" />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>Address
									Line2</label>
								<div class="field_container" align="right">
									<input type="text" id="address2" name="address2"
										style="width: 150px; border: 1px" />
								</div>
								<br /> <label>City</label>
								<div class="field_container" align="left">
									<input type="text" id="city" name="city"
										style="width: 150px; border: 1px" />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>State</label>
								<div class="field_container" align="right">
									<!-- <input type="text" id="state" name="state"
										style="width: 150px; border: 1px" /> -->
									<select id="state" name="state"
										style="width: 150px; border: 1px">
										<option>select</option>
										<option value="Alabama">Alabama</option>
										<option value="Alaska">Alaska</option>
										<option value="Arizona">Arizona</option>
										<option value="Arkansas">Arkansas</option>
										<option value="California">California</option>
										<option value="Colorado">Colorado</option>
										<option value="Connecticut">Connecticut</option>
										<option value="Delaware">Delaware</option>
										<option value="District Of Columbia">District Of Columbia</option>
										<option value="Florida">Florida</option>
										<option value="Georgia">Georgia</option>
										<option value="Hawaii">Hawaii</option>
										<option value="Idaho">Idaho</option>
										<option value="Illinois">Illinois</option>
										<option value="Indiana">Indiana</option>
										<option value="Iowa">Iowa</option>
										<option value="Kansas">Kansas</option>
										<option value="Kentucky">Kentucky</option>
										<option value="Louisiana">Louisiana</option>
										<option value="Maine">Maine</option>
										<option value="Maryland">Maryland</option>
										<option value="Massachusetts">Massachusetts</option>
										<option value="Michigan">Michigan</option>
										<option value="Minnesota">Minnesota</option>
										<option value="Mississippi">Mississippi</option>
										<option value="Missouri">Missouri</option>
										<option value="Montana">Montana</option>
										<option value="Nebraska">Nebraska</option>
										<option value="Nevada">Nevada</option>
										<option value="New Hampshire">New Hampshire</option>
										<option value="New Jersey">New Jersey</option>
										<option value="New Mexico">New Mexico</option>
										<option value="New York">New York</option>
										<option value="North Carolina">North Carolina</option>
										<option value="North Dakota">North Dakota</option>
										<option value="Ohio">Ohio</option>
										<option value="Oklahoma">Oklahoma</option>
										<option value="Oregon">Oregon</option>
										<option value="Pennsylvania">Pennsylvania</option>
										<option value="Rhode Island">Rhode Island</option>
										<option value="South Carolina">South Carolina</option>
										<option value="South Dakota">South Dakota</option>
										<option value="Tennessee">Tennessee</option>
										<option value="Texas">Texas</option>
										<option value="Utah">Utah</option>
										<option value="Vermont">Vermont</option>
										<option value="Virginia">Virginia</option>
										<option value="Washington">Washington</option>
										<option value="West Virginia">West Virginia</option>
										<option value="Wisconsin">Wisconsin</option>
										<option value="Wyoming">Wyoming</option>
									</select>
								</div>
								<br /> <label>Country</label>
								<div class="field_container" align="left">
									<input type="text" id="country" name="country" value="USA"
										style="width: 150px; border: 1px" />
								</div>
								<span style="padding: 0 40px">&nbsp;</span> <label>Zip
									Code</label>
								<div class="field_container" align="right">
									<input type="text" id="zipcode" name="zipcode"
										style="width: 150px; border: 1px" />
								</div>
								<br /> <br />
								<div align="right">
									<!-- <input type="submit" value="Add Member"/> -->
									<!-- <button onclick="addMember()">
										<span class="button_text">Add Member</span>
									</button> -->									
									<button type="submit" form="page_form" formmethod="post" formaction="addMember">
										<span class="button_text">Add Member</span>
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
											<th>Env No.</th>
											<th>Name</th>
											<!-- <th>Last Name</th>
											<th>Middle Name</th> -->
											<th>Address1</th>
											<th>Address2</th>
											<th>city</th>
											<th>state</th>
											<th>country</th>
											<th>Zipcode</th>
											<th>Mobile</th>
											<!-- <th>Email</th> -->
											<!-- <th></th> -->
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (Member member : memberList) {
										%>
										<tr>
											<td id='<%=member.getEnvelopeNo()%>' contenteditable="false"><%=member.getEnvelopeNo()%></td>
											<%
												String name = member.getFirstName() + " " + member.getMiddleName() + " " + member.getLastName();
											%>
											<td id='<%=name%>' contenteditable="true"><%=name%></td>
											<!-- <td contenteditable="true">undefined</td>
											<td contenteditable="true">undefined</td> -->
											<td id='<%=member.getAddress1()%>' contenteditable="true"><%=member.getAddress1()%></td>
											<td id='<%=member.getAddress2()%>' contenteditable="true"><%=member.getAddress2()%></td>
											<td id='<%=member.getCity()%>' contenteditable="true"><%=member.getCity()%></td>
											<td id='<%=member.getState()%>' contenteditable="true"><%=member.getState()%></td>
											<td id='<%=member.getCountry()%>' contenteditable="true"><%=member.getCountry()%></td>
											<td id='<%=member.getZipcode()%>' contenteditable="true"><%=member.getZipcode()%></td>
											<td id='<%=member.getMobile()%>' contenteditable="true"><%=member.getMobile()%></td>
											<!-- <td contenteditable="true">undefined</td> -->
											<td><input type="button" value="Update"
												onclick="updateMember(getElementById('<%=member.getEnvelopeNo()%>').innerHTML,
																									getElementById('<%=name%>').innerHTML,
																									getElementById('<%=member.getAddress1()%>').innerHTML,
																									getElementById('<%=member.getAddress2()%>').innerHTML,
																									getElementById('<%=member.getCity()%>').innerHTML,
																									getElementById('<%=member.getState()%>').innerHTML,
																									getElementById('<%=member.getCountry()%>').innerHTML,
																									getElementById('<%=member.getZipcode()%>').innerHTML,
																									getElementById('<%=member.getMobile()%>').innerHTML)">
												<input type="button" value="Delete"
												onclick="deleteMember(getElementById('<%=member.getEnvelopeNo()%>').innerHTML)">
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td style="height: 0.5mm;">&#160;</td>
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
