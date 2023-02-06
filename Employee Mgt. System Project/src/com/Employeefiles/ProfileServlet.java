package com.Employeefiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("/html/header.html").include(request, response);
		HttpSession session=request.getSession(false);
		
		System.out.println("Session id : "+session.getId());
		
		String id=(String) session.getAttribute("empid");
		
		try
		{
			if(!(id.equals("") || id.equals(null)))
			{
			
			out.println("<h4 style='text-align:right'>You are successfully logged in !</h4>");
	
			request.getRequestDispatcher("html/CustomerOperations.html").include(request, response);
			
			}
		}catch(NullPointerException ne)
		{
				out.print("<h1>Please login first!</h1>");
		}
	}
}
