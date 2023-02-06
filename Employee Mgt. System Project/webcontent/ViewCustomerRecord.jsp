<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/html/header.html"/>
<form action="GetCustomerRecord.jsp " method="get">
	Enter Customer Id : <input type="text" name="cid" /><br><br>
	<input type="submit" name="submit" value="Get Customer Record" />
</form>

</body>
</html>