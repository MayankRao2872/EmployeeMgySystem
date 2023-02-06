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
<form action="deletecustomer1.jsp">
	Enter Id : <input type="text" name="cid" /><br><br>
	Password : <input type="password" name="cpass" /><br><br>
	<input type="submit" value="Delete Customer Record" name="submit"/>
</form>

</body>
</html>