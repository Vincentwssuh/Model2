<%@page import="net.member.db.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		String id = (String) session.getAttribute("id");

		if (id == null) {
			response.sendRedirect("./MemberLogin.me");
		}
		List memberList = (List)request.getAttribute("memberList");
	%>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>가입일</td>
			<td>나이</td>
			<td>성별</td>
			<td>e-메일</td>
		</tr>
		<%
			for (int i = 0; i < memberList.size(); i++) {
				//부모에서 자식으로 형변환. 다운캐스팅.
				//형 변환을 명시해야 한다.
				MemberBean mb = (MemberBean)memberList.get(i);
		%>
		<tr>
			<td><%=mb.getId()%></td>
			<td><%=mb.getPass()%></td>
			<td><%=mb.getName()%></td>
			<td><%=mb.getReg_data()%></td>
			<td><%=mb.getAge()%></td>
			<td><%=mb.getGender()%></td>
			<td><%=mb.getEmail()%></td>
		</tr>
		<%
			}
		%>
		
	</table>
	<a href="./Main.me">main으로 이동</a>
</body>
</html>