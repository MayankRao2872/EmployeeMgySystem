<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="html/header.html"/>
<%
	String id=(String)request.getAttribute("cid");
	String pass=(String)request.getAttribute("pass");
	String name=(String)request.getAttribute("name");
	String phone=(String)request.getAttribute("phone");
	String email=(String)request.getAttribute("email");	
%>
Customer id: <%=id %>

<form action="UpdateServlet1">
	<input type="hidden" name="cid" value="<%=id %>"/>
	Password : <input type="password" name="cpass" value="<%=pass %>"/><br><br>
	Name : <input type="text" name="cname" value="<%=name %>"/><br><br>
	Phone : <input type="number" name="cphone" value="<%=phone %>"/><br><br>
	Email-Id : <input type="email" name="cmail" value="<%=email %>"/><br><br>
	<input type="submit" name="submit" value="Update Customer " />
</form>
</body>
</html>