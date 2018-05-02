/*
 Class		 :	OperationServlet
 Description :	This class is used to perform CRUD operations based on form action
 				attribute.
 */

package church.finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class OperationsServlet
 */
public class OperationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store"); 
		response.setHeader("Pragma", "no-cache"); 
		PrintWriter out = response.getWriter();		
		session = request.getSession();
		Member member = new Member();
		Report report = new Report();
		Donation donation = new Donation();
		DonationManagement mgmt = new DonationManagement();
		String action = request.getServletPath();
		//It forwards to members page if servlet path equals to memberPage
		if(action.equals("/memberPage")){				
				session.setAttribute("memberList",mgmt.getMembers());
				response.sendRedirect("member.jsp");
				
		}
		//It forwards to funds page if servlet path equals to fundPage
		if(action.equals("/fundPage")){
			session.setAttribute("fundMap",mgmt.getFunds());
			response.sendRedirect("fund.jsp");
			
		}
		//It forwards to donations page if servlet path equals to donationPage
		if(action.equals("/donationPage")){
			session.setAttribute("fundMap",mgmt.getFunds());
			session.setAttribute("donationList",mgmt.getDonations());
			response.sendRedirect("donation.jsp");
			
		}
		//It forwards to reports page if servlet path equals to reportPage
		if(action.equals("/reportPage")){				
			session.setAttribute("fundMap",mgmt.getFunds());
			//session.setAttribute("reports",mgmt.getDonations());
			response.sendRedirect("reports.jsp");
			
		}
		//It updates members table if servlet path equals to memberUpdate
		if(action.equals("/memberUpdate")){
			String[] names = ((String)request.getParameter("name")).split(" ");
			String firstName;
			String middleName;
			String lastName;
			if(names.length == 3){
				firstName = names[0];
				middleName = names[1];
				lastName = names[2];
				//System.out.println(firstName + "," + middleName + "," + lastName);
			}
			else{
				//System.out.println("no Middle");
				firstName = names[0];
				middleName = "";
				lastName = names[1];
			}
			
			member.setEnvelopeNo(Integer.parseInt((String)request.getParameter("envelopeNo")));
			member.setFirstName(firstName);
			member.setLastName(lastName);
			member.setMiddleName(middleName);
			member.setMobile(Long.parseLong((String)request.getParameter("mobile")));
			//member.setEmail((String)request.getParameter("email"));
			member.setAddress1((String)request.getParameter("address1"));
			member.setAddress2((String)request.getParameter("address2"));
			member.setCity((String)request.getParameter("city"));
			member.setState((String)request.getParameter("state"));
			System.out.println((String)request.getParameter("country"));
			member.setCountry((String)request.getParameter("country"));
			member.setZipcode(Long.parseLong((String)request.getParameter("zipcode")));
			
			if("success".equalsIgnoreCase(mgmt.updateMember(member)))
				session.setAttribute("memberList",mgmt.getMembers());
			
		}
		//It deletes member from members table if servlet path equals to memberDelete
		if(action.equals("/memberDelete")){
			int envelopeNo = Integer.parseInt((String)request.getParameter("envelopeNo"));
			if("success".equalsIgnoreCase(mgmt.deleteMember(envelopeNo))){
				session.setAttribute("memberList",mgmt.getMembers());
				
			}
		}
		//It adds member to members table if servlet path equals to addMember
		if(action.equals("/addMember")){
			member.setEnvelopeNo(Integer.parseInt((String)request.getParameter("envelopeNo")));
			member.setFirstName((String)request.getParameter("firstName"));
			member.setLastName((String)request.getParameter("lastName"));
			member.setMiddleName((String)request.getParameter("middleName"));
			member.setMobile(Long.parseLong((String)request.getParameter("mobile")));
			member.setEmail((String)request.getParameter("email"));
			member.setAddress1((String)request.getParameter("address1"));
			member.setAddress2((String)request.getParameter("address2"));
			member.setCity((String)request.getParameter("city"));
			member.setState((String)request.getParameter("state"));
			member.setCountry((String)request.getParameter("country"));
			member.setZipcode(Long.parseLong((String)request.getParameter("zipcode")));
			
			if("success".equalsIgnoreCase(mgmt.addMember(member))){
				session.setAttribute("memberList",mgmt.getMembers());
				response.sendRedirect("member.jsp");
				
			}
		}
		//It adds fund to funds table if servlet path equals to addFund
		if(action.equals("/addFund")){			
			if("success".equalsIgnoreCase(mgmt.addFund(Integer.parseInt((String)request.getParameter("fundNo")),(String)request.getParameter("fundName")))){
				session.setAttribute("fundMap",mgmt.getFunds());
				response.sendRedirect("fund.jsp");
			}
		}
		//It update fund in funds table if servlet path equals to updateFund
		if(action.equals("/updateFund")){			
			if("success".equalsIgnoreCase(mgmt.updateFund(Integer.parseInt((String)request.getParameter("fundNo")),(String)request.getParameter("fundName")))){
				session.setAttribute("fundMap",mgmt.getFunds());
				
			}			
		}
		//It deletes fund from funds table if servlet path equals to deleteFund
		if(action.equals("/deleteFund")){			
			if("success".equalsIgnoreCase(mgmt.deleteFund(Integer.parseInt((String)request.getParameter("fundNo"))))){
				session.setAttribute("fundMap",mgmt.getFunds());
			}			
		}
		//It adds donation to donations table if servlet path equals to addDonation
		if(action.equals("/addDonation")){			
			/*if("success".equalsIgnoreCase(mgmt.addFund(Integer.parseInt((String)request.getParameter("fundNo")),(String)request.getParameter("fundName")))){
				session.setAttribute("fundMap",mgmt.getFunds());
			}*/
			donation.setEnvelopeNumber(Integer.parseInt((String)request.getParameter("envelopeNo")));
			donation.setFundName((String)request.getParameter("fundName"));
			donation.setAmount(Double.parseDouble((String)request.getParameter("amount")));
			donation.setAmountType((String)request.getParameter("amountType"));
			try {
				donation.setDate(new java.sql.Date((formatter.parse(((String)request.getParameter("date")))).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			donation.setDescription((String)request.getParameter("description"));
			//System.out.println(donation.toString());
			if("success".equalsIgnoreCase(mgmt.addDonation(donation))){
				session.setAttribute("donationList",mgmt.getDonations());
				response.sendRedirect("donation.jsp");
			}
		}
		//It update donation in donations table if servlet path equals to updateDonation
		if(action.equals("/updateDonation")){			
			/*if("success".equalsIgnoreCase(mgmt.addFund(Integer.parseInt((String)request.getParameter("fundNo")),(String)request.getParameter("fundName")))){
				session.setAttribute("fundMap",mgmt.getFunds());
			}*/
			donation.setDonationId(Integer.parseInt((String)request.getParameter("donationId")));
			donation.setEnvelopeNumber(Integer.parseInt((String)request.getParameter("envelopeNo")));
			donation.setFundName((String)request.getParameter("fundName"));
			donation.setAmount(Double.parseDouble((String)request.getParameter("amount")));
			donation.setAmountType((String)request.getParameter("amountType"));
			try {
				donation.setDate(new java.sql.Date((formatter.parse(((String)request.getParameter("date")))).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//donation.setDescription((String)request.getParameter("description"));
			//System.out.println(donation.toString());
			if("success".equalsIgnoreCase(mgmt.updateDonation(donation))){
				session.setAttribute("donationList",mgmt.getDonations());
				//response.sendRedirect("donation.jsp");
			}
		}
		//It delete donation from donations table if servlet path equals to deleteDonation
		if(action.equals("/deleteDonation")){
			
			if("success".equalsIgnoreCase(mgmt.deleteDonation(Integer.parseInt((String)request.getParameter("donationId"))))){
				session.setAttribute("donationList",mgmt.getDonations());
			}			
		}
		//It generate reports from donations table if servlet path equals to getReport
		if(action.equals("/getReport")){
			java.sql.Date from = null;
			try {
				if(request.getParameter("from") != null && request.getParameter("from") != ""){
					session.setAttribute("from",(String)request.getParameter("from"));
					from = new java.sql.Date((formatter.parse(((String)request.getParameter("from")))).getTime());
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date to = null; 
			try {
				if(request.getParameter("to") != null && request.getParameter("to") != ""){
					session.setAttribute("to",request.getParameter("to"));
					to = new java.sql.Date((formatter.parse(((String)request.getParameter("to")))).getTime());					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int env = 0;
			if(request.getParameter("env") != null && request.getParameter("env") != ""){
				session.setAttribute("env",(String)request.getParameter("env"));
				env = Integer.parseInt((String)request.getParameter("env"));		
			}
			String fund = null;
			if(request.getParameter("type") != ""){
				fund = (String)request.getParameter("type");	
				session.setAttribute("fund",fund);
			}
			String fn = null;
			if(request.getParameter("fn") != ""){
				session.setAttribute("fn",(String)request.getParameter("fn"));
				fn = (String)request.getParameter("fn");
			}
			String ln = null;
			if(request.getParameter("ln") != ""){
				session.setAttribute("ln",(String)request.getParameter("ln"));
				ln = (String)request.getParameter("ln");				
			}
			String sql = report.getReportQuery(from, to, env, fund, fn, ln);
			//System.out.println(sql);
			//System.out.println(from + "," + to + "," + env + "," + fund + "," + fn + "," + ln);
			if(from == null)
				session.setAttribute("from","");				
			if(to == null)
				session.setAttribute("to","");
			if(env == 0)
				session.setAttribute("env","");
			if(fund == null)
				session.setAttribute("fund","");
			if(fn == null)
				session.setAttribute("fn","");
			if(ln == null)
				session.setAttribute("ln","");
			
			session.setAttribute("reports", mgmt.getReports(sql));
			/*if("success".equalsIgnoreCase(mgmt.deleteDonation(Integer.parseInt((String)request.getParameter("donationId"))))){
				session.setAttribute("donationList",mgmt.getDonations());
			}*/		
			response.sendRedirect("reports.jsp");
			//System.out.println(Integer.parseInt((String)request.getParameter("env")));
		}
		//It will send password in case of forgot password
		if(action.equals("/getPassword")){
			new SendPasswordMail((String)request.getParameter("email"), "secretary");
		}
		//It is used to logout from the application and invalidates session before logout
		if(action.equals("/logout")){
			session.setAttribute("memberList",null);
			session.setAttribute("fundMap",null);
			session.setAttribute("donationList",null);
			session.invalidate();
			//response.sendRedirect("login.jsp");
		}
	}

}
