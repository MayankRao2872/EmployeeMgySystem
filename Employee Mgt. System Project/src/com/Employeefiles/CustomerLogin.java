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
@WebServlet("/NewCustomer")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
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
				
				// send values to Dao class
				
				c=CustomerDao.checkLogin(c);
				
				if(!(c.getName().equals("") || c.getName().equals(null)))
					out.print("<h1>You are logged in Successfully!</h1>");
				
				else
					out.print("<h1>Either Id or password is incorrect!</h1>");
				
				out.close();
				
		
	}

}
