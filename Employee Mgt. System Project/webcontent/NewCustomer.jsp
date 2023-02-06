<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="html/header.html"/>
<br>
<hr size="3" />
<body>
	<form action="CustomerLogin" method="post">
		Enter Customer Id  : <input type="text" name="cid" /><br><br>
		Enter Password     : <input type="password" name="cpass" /><br><br>
		Enter Name		   : <input type="text" name="cname" /><br><br>
		Enter Phone		   : <input type="number" name="cphone" /><br><br>
		Enter Email        : <input type="email" name="cmail" /><br><br>
		<input type="submit" name="submit" value="Register Customer" />
		<input type="reset" name="reset" value="Reset" /> 
	</form>
</body>
</html> 