package com.Employeefiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Employee;
import com.Model.EmployeeDao;

/**
 * Servlet implementation class NewEmployee
 */
@WebServlet("/NewEmployee")
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//create the object of Employee class
		Employee emp=new Employee();
		
		//get details from the form and set them in bean class
		emp.setEmpid(request.getParameter("empid"));
		emp.setName(request.getParameter("empname"));
		emp.setPhone(Integer.parseInt(request.getParameter("phone")));
		emp.setSalary(Float.parseFloat(request.getParameter("salary")));
		
		// send the object emp to EmployeeDao class to insert them in database
		// get status if the record is stored or not
		int status = EmployeeDao.addNewEmployee(emp);
		
		//set the content type of the response
		response.setContentType("text/html");
		
		//getWriter from response into object of PrintWriter
		PrintWriter out= response.getWriter();
		
		if(status==1)
			out.print("<h1>Record Saved Successfully !</h1>");
		else
			out.print("Unable to Save Record !");
		
		out.close();
  		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
