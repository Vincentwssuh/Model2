<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WebContent/jstl/jstl_fmt.jsp</h1>

	<fmt:requestEncoding value="utf-8" />

	<fmt:setLocale value="en_US" />

	<!-- 	통화 표시 방법	 -->
	<fmt:formatNumber value="50000" type="currency"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="0.15" type="percent"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="50000" pattern="###,###,###"></fmt:formatNumber>
	<br>
	
	
	<!-- 	날짜 표시 방법 -->
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<fmt:formatDate value="${date }" type="date" />
	<br>
	<fmt:formatDate value="${date }" type="time" />
	<br>
	<fmt:formatDate value="${date }" type="both" />


</body>
</html>