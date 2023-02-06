package com.Employeefiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Customer;
import com.Model.CustomerDao;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class NewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCustomer() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				// set response 
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				// Get values from form using request
				Customer c=new Customer();
				
				c.setCid(Integer.parseInt(request.getParameter("cid")));
				c.setPass(request.getParameter("cpass"));
				c.setName(request.getParameter("cname"));
				c.setPhone(Integer.parseInt(request.getParameter("cphone")));
				c.setEmailid(request.getParameter("cmail"));
				
				// send values to Dao class
				 
				int status= CustomerDao.AddNewCustomer(c);
				
				request.getRequestDispatcher("html/header.html").include(request, response);
				
				if(status==1)
					out.print("<h1>Record Inserted Successfully!</h1>");
				
				else
					out.print("<h1>Unable to Insert record!</h1>");
				
				out.close();
				
		
	}

}
