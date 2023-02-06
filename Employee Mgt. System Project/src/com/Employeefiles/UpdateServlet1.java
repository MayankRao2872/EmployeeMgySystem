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
 * Servlet implementation class UpdateServlet1
 */
@WebServlet("/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet1() {
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
		
		// Get values from form using request
		Customer c=new Customer();
		
//		String id=request.getParameter("cid");
		
		c.setCid(Long.parseLong(request.getParameter("cid")));
		c.setPass(request.getParameter("cpass"));
		c.setName(request.getParameter("cname"));
		c.setPhone(Integer.parseInt(request.getParameter("cphone")));
		c.setEmailid(request.getParameter("cmail"));
		
		// send values to Dao class
		
		int status = CustomerDao.updateServlet(c);
		
		if(status==1)
		{
			out.print("<h1>Record Updated Successfully !</h1>");
		}
		else
		{
			out.print("<h1>Unable to Update Record !</h1>");
		}
		out.close();
	}

}
