<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center; background-color: skyblue">
<jsp:include page="/html/header.html"/>
<br></br>
<h1>Employee Login</h1>
<form action="login" method="get">          
	Enter User Id : <input type="text" name="uid"/><br></br>
	Enter Password : <input type="password" name="upass"/><br></br>
	<input type="submit" name="submit" value="Login">
	<input type="reset" name="reset" value="Reset Form">

</form>
<br>
<hr size="5" />
<h2><a href="NewEmployee.jsp">New Employee Registration</a></h2>
<h2><a href="GeneratePassword.jsp">Generate Password</a></h2>

</body>
</html>