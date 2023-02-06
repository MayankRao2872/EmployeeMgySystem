<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Model.CustomerDao,com.Model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/html/header.html"/>

<br>
<%
	int cid= Integer.parseInt(request.getParameter("cid"));

 	Customer c=CustomerDao.getRecord(cid);
%>

<h1>Customer Details</h1>
<h3>Customer Id : <%=c.getCid() %></h3>
<h3>Password    : <%=c.getPass() %></h3>
<h3>Name        : <%=c.getName() %></h3>
<h3>Phone       : <%=c.getPhone() %></h3>
<h3>Email-Id    : <%=c.getEmailid() %></h3>
	
</body>
</html>