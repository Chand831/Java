/*
 Class		 :	MemberServlet
 Description :	This class is used to populate member object from the user
  				input and store that in members table and forward it to the
  				members page.
 */

package church.finance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache, no-store"); 
		response.setHeader("Pragma", "no-cache"); 
		HttpSession session = request.getSession();
		DonationManagement mgmt = new DonationManagement();
		Member member = new Member();				
		
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
		
		//out.println(member);
		if(mgmt.addMember(member).equals("success")){
			session.setAttribute("memberList",mgmt.getMembers());
			response.sendRedirect("member.jsp");
		}
	}

}
