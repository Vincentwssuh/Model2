<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Webcontent/jstl/el.jsp</h1>

	<%
		//EL(EXPRESSION lANGUAGE) : 표현언어
		//EL 내장 객체 sessionScope	param 등을 사용할 수 있다.
		session.setAttribute("sesname", "session value");
	%>
	<%--	<%= %>대신에 ${ }를 사용한다.	--%>

	<form action="el2.jsp" method="post">
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>