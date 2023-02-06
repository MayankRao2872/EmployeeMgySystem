<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Model.CustomerLogin,com.Model.CustomerDao" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/html/header.html"/>

<jsp:useBean id="cus" class="com.Model.CustomerLogin"/>
<jsp:setProperty property="*" name="cus"/>

<%
	int status = CustomerDao.deleteCustomer(cus);

	if(status==1)
	{
%>	
		<h1>Unable to Deleted Record!</h1>	
<% 		
	}
	else
	{
%>		
		<h1>Record Deleted Successfully !</h1>
<% 		
	}
%>	


</body>
</html>