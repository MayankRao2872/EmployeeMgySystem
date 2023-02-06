package com.Employeefiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.EmployeeLogin;
import com.Model.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmployeeLogin emplog=new EmployeeLogin();
		emplog.setUid(request.getParameter("uid"));
		emplog.setUpass(request.getParameter("upass"));
		
		emplog=LoginDao.checkLogin(emplog);
		                
		
		
		//to generate response
		//1. set the content type of the page
		//2. get the writer for writing into response
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(!(emplog.getUname().equals(null) || emplog.getUname().equals("")))
		{
			HttpSession session=request.getSession();
			
			session.setAttribute("empid", emplog.getUid());
			
			RequestDispatcher rd= request.getRequestDispatcher("ProfileServlet");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h1 style='color:red;'>Either id or password is incorrect </h1>");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();
		
	}

}
