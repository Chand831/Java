/*
 Class		 :	LoggingServlet
 Description :	This class is used to authenticate user and it will forward to members page  
 				if authentication is successful otherwise it will forward to login page. 
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
 * Servlet implementation class LoggingServlet
 */
public class LoggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoggingServlet() {
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
		//doGet(request, response);
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store"); 
		response.setHeader("Pragma", "no-cache"); 
		
		session = request.getSession();
		
		PrintWriter out = response.getWriter();
		//Retrieve username and password from login page.
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		//validates user
		if(username.equals("wuthrich")){
			if(password.equalsIgnoreCase("secretary")){
				session.setAttribute("memberList",new DonationManagement().getMembers());
				response.sendRedirect("member.jsp");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		}
		else{
			response.sendRedirect("login.jsp");
		}
	}

}
