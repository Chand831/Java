<!-- 
	This page is used to generate and print the reports based on the user input.
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Map,java.text.SimpleDateFormat"%>
<%@ page import="church.finance.Donation,church.finance.Report"%>
<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	double total = 0.0;
	String fn = "";
	String ln = "";
	String fund = ""; 
	String env = "";
	String from = null;
	String to = null;
	HashMap<Integer, String> fundMap = (HashMap<Integer, String>) session.getAttribute("fundMap");
	ArrayList<Report> reportList = (ArrayList<Report>)session.getAttribute("reports");
	/* if(session.getAttribute("from") != null && session.getAttribute("to") != null && session.getAttribute("env") != null){
		fn = (String)session.getAttribute("fn");
		ln = (String)session.getAttribute("ln");
		env = Integer.parseInt(session.getAttribute("env").toString());
		fund = (String)session.getAttribute("fund");
		from = new java.sql.Date((formatter.parse((session.getAttribute("from")).toString())).getTime());
		to = new java.sql.Date((formatter.parse((session.getAttribute("to")).toString())).getTime());
	} */
		fn = (String)session.getAttribute("fn");
		ln = (String)session.getAttribute("ln");
		env = (String)session.getAttribute("env");
		fund = (String)session.getAttribute("fund");
		from = (String)session.getAttribute("from");
		to = (String)session.getAttribute("to");
		if(reportList != null){
			for(Report report : reportList){
				total = total +  report.getAmount();
			}
		}
		
		String reportInfo = "<br/><br/>";
		if(fn != "")
			reportInfo = reportInfo + fn + "&nbsp;&nbsp;";
		if(ln != "")
			reportInfo = reportInfo + ln;
		if(env != "")
			reportInfo = reportInfo + "<br/> Envelope No. :" + env;
		if(fund != "")
			reportInfo = reportInfo + "<br/> Fund Type : " + fund;
		if(from != "")
			reportInfo = reportInfo + "<br/> From : " + from;
		if(to != "")
			reportInfo = reportInfo + "&nbsp; To : " + to + "<br/><br/>";
%>

<!DOCTYPE html>
<html>
<head>
<title>Reports</title>
<meta charset="UTF-8" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
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
	border-radius: 8px;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-wekbit-box-sizing: border-box;
	border: 8px solid #F5F3F0;
	display: inline-block;
	margin: 6px auto 0;
	padding: 80px 100px 40px;
	position: absolute;
	left: 8%;
	right: 8%;
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
	padding: 2px;
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

p.bold {
	font-weight: bold;
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
	<!--<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	<script>
			$(function() {
				$('#etable').DataTable();		
			});
	</script> -->
	<script type="text/javascript">
		var request;
		
		function LoadOnce() {
			window.location.reload();
		}
		
		function onShowTab(index) {			
			var numberTabs = 4;
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
		
		//This function is used to print report
		function printDiv(divName, con, per, line, data, pic) {
			//alert();
			document.getElementById(pic).innerHTML = document.getElementById("img").innerHTML;
			document.getElementById(con).innerHTML = "<br/><br/><br/> Colonial Church <br/> 4300 Maplewood Ave, <br/> Wichita Falls,<br/> TX 76308";
			
			document.getElementById(per).innerHTML = "<%=reportInfo%>";
			document.getElementById(line).innerHTML = "<hr>";

			document.getElementById(data).innerHTML = "<p align='center'>Contribution Statement</p><p class='bold' align='center'><br/>Total :$ <%=total%></p><p><br/> We acknowledge by this statement that no goods or services were provided to the donor in exchange for the contributions listed herein.</p><br/>";

			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;
		}
		
		function getRequest() {				
			if (window.ActiveXObject) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else
				return null;
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
				<img src="./images/church.png" align="right" alt="Mountain View"
					style="width: 75px; height: 75px;">
			</div>
			<table width="100%">
				<tbody>
					<tr>
						<td>
							<div align="right">
								<button
									onclick="printDiv('etab','con','per','line','data','pic')">
									<span class="button_text">Print</span>
								</button>

							</div> <label> Date Range</label> <br /> <label> From </label>
							<div class="field_container">
								<input id="from" name="from" type="date" style="width: 150px; border: 1px" />
							</div> <span style="padding: 0 20px">&nbsp;</span> <label>TO</label>
							<div class="field_container">
								<input id="to" name="to" type="date" style="width: 150px; border: 1px" />
							</div> <br /> <label>Fund type</label>
							<div class="field_container">
								<select id="type" name="type" style="width: 150px; border: 1px">
									<option></option>
									<% for (Map.Entry<Integer, String> entry : fundMap.entrySet()) { %>
										<option value='<%=entry.getValue()%>'> <%=entry.getValue()%> </option>
									<%} %>
								</select>

							</div> <span style="padding: 0 20px">&nbsp;</span> <label>Envelope
								No.</label>
							<div class="field_container">
								<input id="env" name="env" type="text" style="width: 150px; border: 1px" />
							</div> <br /> <label>Last Name</label>
							<div class="field_container">
								<input id="ln" name="ln" type="text" style="width: 150px; border: 1px" />
							</div> <span style="padding: 0 17px">&nbsp;</span> <label>First
								Name</label>
							<div class="field_container">
								<input id="fn" name="fn" type="text" style="width: 150px; border: 1px" />
							</div> <br />

							<div align="right">
								<span style="padding: 0 10px">&nbsp;</span>
								<button type="submit" form="page_form"  formmethod="post" formaction="getReport">
									<span class="button_text">Search</span>
								</button>
								&nbsp;&nbsp;
								<button type="reset">
									<span class="button_text">Reset</span>
								</button>
							</div> <br /> <br />
							<div id="etab">
								<div id="pic" align="right"></div>
								<div id="con" align="left"></div>
								<div id="per" align="left"></div>
								<div id="line"></div>
								<div id="data"></div>
								<%if(reportList != null && !(reportList.isEmpty())){ %>
								<table id="etable" cellspacing="0">									
									<thead>
										<tr class="head">
											<th>Date</th>
											<th>Amount</th>
											<th>Fund</th>
											<th>Description</th>
										</tr>
									</thead>
									<tbody>
										<% 
												for(Report report : reportList ){													
										%>
										
										<tr>
											<td><%=report.getDate() %></td>
											<td><%=report.getAmount() %></td>
											<td><%=report.getFund() %></td>
											<td><%=report.getDescription() %></td>

										</tr>
										<%}}%>
										<!-- <tr>
											<td>01/25/2015</td>
											<td>100.00</td>
											<td>Building Fund</td>
											<td></td>

										</tr>
										<tr>
											<td>02/22/2015</td>
											<td>100.00</td>
											<td>Food Supplies</td>
											<td>for Congregal Bun, BBQ sauce <br />for voter's
												meeting
											</td>

										</tr> -->
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

</body>
</html>