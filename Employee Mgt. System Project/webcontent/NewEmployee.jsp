<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="NewEmployee" method="get">
		Employee ID  : <input type="text" name="empid" /><br><br>
		Employee Name: <input type="text" name="empname" /><br><br>
		Phone        : <input type="number" name="phone" /><br><br>
		Salary       : <input type="text" name="salary" /><br><br>
		<input type="submit" name="submit" value="Register"/>
	</form>
</body>
</html>