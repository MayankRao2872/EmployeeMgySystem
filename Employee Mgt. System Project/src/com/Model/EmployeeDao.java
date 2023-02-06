package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao 
{
	static Connection con;
	static Statement st;
	static ResultSet rs;
	private static PreparedStatement ps;
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found !");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc","root","2872");
			System.out.println("Connection created");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int addNewEmployee(Employee emp) 
	{
		int status=0;
		try 
		{
			st=con.createStatement();
			System.out.println("Statement created ");
			status=st.executeUpdate("insert into employee values('"+emp.getEmpid()+"','"+emp.getName()+"',"+emp.getPhone()+","+emp.getSalary()+")");
			System.out.println("Record Inserted : "+ status);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Employee viewRecord(String uid)
	{
		Employee emp=new Employee();  
		try 
		{
			ps=con.prepareStatement("select * from employee where empid=?");
			ps.setString(1, uid);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				emp.setEmpid(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setPhone(rs.getInt(3));
				emp.setSalary(rs.getFloat(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}



}
