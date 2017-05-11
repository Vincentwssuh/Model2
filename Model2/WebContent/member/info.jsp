
<%@page import="net.member.db.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>info.jsp</h1>


	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		String id = (String) session.getAttribute("id");
		if(id==null)response.sendRedirect("./Main.me");
		
	//	저장된 MemberBean mb 데이터 가져오기
	MemberBean mb = (MemberBean)request.getAttribute("mb");
						// ㄴ object 타입으로 저장되었다가,
						//    다시 불러올때는 MemberBean타입으로.
	%>
	아이디:		<%=mb.getId() %>	<br>
	비밀번호:	<%=mb.getPass() %><br>
	이름:		<%=mb.getName() %><br>
	가입 일자 :	<%=mb.getReg_date() %>
	나이:		<%=mb.getAge() %><br>
	성별:		<%=mb.getGender() %><br>
	이메일:		<%=mb.getEmail() %><br>
	
	<!-- 	<input type="button" value="main으로 이동" -->
	<!-- 		onclick="location.href='main.jsp'"> -->
	<a href="./Main.me">main으로 이동</a>


</body>
</html>