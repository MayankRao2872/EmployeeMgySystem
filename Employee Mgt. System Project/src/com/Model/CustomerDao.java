package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao 
{
	 static Connection con;
	 static java.sql.Statement st;
	 static ResultSet rs;
	
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found .");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc","root","2872");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static ArrayList<Customer> getAllCustomers()
	{
		ArrayList<Customer> clist= new ArrayList<Customer>();
		
		try {
			con=createConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from customer");
			
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCid(rs.getInt(1));
				c.setPass(rs.getString(2));
				c.setName(rs.getString(3));
				c.setPhone(rs.getInt(4));
				c.setEmailid(rs.getString(5));
				
				clist.add(c);
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clist;
	}

	public static int AddNewCustomer(Customer c) 
	{
		int status=0;
		try 
		{
			con=createConnection();
			st=con.createStatement();
			status=st.executeUpdate("insert into customer values("+c.getCid()+",'"+c.getPass()+"','"+c.getName()+"',"+c.getPhone()+",'"+c.getEmailid()+"')");
			st.close();
			con.close();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	public static Customer checkLogin(Customer c) 
	{
		try {
			con=createConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from customer where customerid="+c.getCid()+" and password='"+c.getPass()+"'");
			if(rs.next())
			{
				c.setName(rs.getString(3));
//				System.out.println("Customer name : "+c.getName());
				c.setPhone(rs.getInt(4));
				c.setEmailid(rs.getString(5));
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c ;
	}

	public static Customer getRecord(int id) 
	{
		Customer c=new Customer();
		System.out.println("id :"+id);
		try {
			con=createConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from customer where customerid=" +id);
			
			if(rs.next())
			{
				System.out.println("Record found");
				c.setCid(rs.getInt(1));
				System.out.println("id :"+c.getCid());
				c.setPass(rs.getString(2));
				c.setName(rs.getString(3));
				c.setPhone(rs.getInt(4));
				c.setEmailid(rs.getString(5));
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return c;
	}

	public static int updateServlet(Customer c) 
	{
		int status=0;
		try {
			con=createConnection();
			st=con.createStatement();
			status=st.executeUpdate("update customer set password='"+c.getPass()+"',customer_name='"+c.getName()+"',phone="+c.getPhone()+",email_id='"+c.getEmailid()+"' where customerid="+c.getCid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	public static int deleteCustomer(CustomerLogin c)
	{
		int status=0;
	
		try {
			con=createConnection();
			st=con.createStatement();
			status=st.executeUpdate("delete from customer where customerid="+c.getCid()+" and password='"+c.getCpass()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
