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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id=Integer.parseInt(request.getParameter("userid"));
		Customer c=CustomerDao.getRecord(id);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		if(c.getCid()!=0)
		{
			request.setAttribute("cid",""+ c.getCid());
			request.setAttribute("pass", c.getPass());
			request.setAttribute("name", c.getName());
			request.setAttribute("phone",""+ c.getPhone());
			request.setAttribute("email", c.getEmailid());
			System.out.println("Name : "+ request.getAttribute("name"));
			
			request.getRequestDispatcher("UpdateCustomer.jsp").include(request, response);
			
		}
		else
		{
			out.print("<h1>Id does not Exist !</h1>");
			request.getRequestDispatcher("CustomerOperations.jsp").include(request, response);
		}
		
	}

}
