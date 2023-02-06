package com.Employeefiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Customer;
import com.Model.CustomerDao;

/**
 * Servlet implementation class ViewAll
 */
@WebServlet("/ViewAll")
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// set response 
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// Get values of customer from Dao class
		
		ArrayList<Customer> clist=CustomerDao.getAllCustomers();
		
		request.getRequestDispatcher("html/header.html").include(request, response);
		
		out.print("<table border='4' size='100%>'");
		out.print("<tr>");
		out.print("<th>Customer ID</th><th>Name</th><th>Password</th><th>Phone</th><th>E-Mail</th>");
		out.print("</tr>");
		
		for(Customer c:clist)
		{
			out.print("<tr>");
			out.print("<td>"+c.getCid()+"</td>");
			out.print("<td>"+c.getName()+"</td>");
			out.print("<td>"+c.getPass()+"</td>");
			out.print("<td>"+c.getPhone()+"</td>");
			out.print("<td>"+c.getEmailid()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
		out.close();
	}

}
