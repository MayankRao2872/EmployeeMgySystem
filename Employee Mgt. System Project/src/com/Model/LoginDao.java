package com.Model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao 
{
	static Connection con;
	static java.sql.Statement st;
	static ResultSet rs;
	
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found .");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc","root","2872");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static EmployeeLogin checkLogin(EmployeeLogin el)
	{
		try {
			st=con.createStatement();
			rs=st.executeQuery("Select * from login where userid='"+el.getUid()+"' and password='"+el.getUpass()+"'");
			
			if(rs.next())
			{
				el.setUname(rs.getString(3));
//				System.out.println("customer name : "+el.getUname());
			}
			else 
				el.setUname("");
			rs.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return el;
	}

}
