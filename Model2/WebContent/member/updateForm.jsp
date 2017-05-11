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
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
	String id = (String) session.getAttribute("id");
	
	if(id == null){	//세션이 없으면 로그인 페이지로.
		response.sendRedirect("./Main.me");
	}

	MemberBean mb = (MemberBean)request.getAttribute("mb");
	%>

<form action="./MemberUpdateAction.me" method="post" name="fr">
	아이디 :	<input type="text" name="id" value="<%=mb.getId()%>" readonly><br>
	비밀번호 : <input type="password" name="pass"><br>
	이름 :	<input type="text" name="name" value="<%=mb.getName()%>"><br>
	나이 :	<input type="text" name="age" value="<%=mb.getAge()%>"><br>
	성별 :	<input type="radio" name="gender" value="man" 
			<%if(mb.getGender() == null || mb.getGender().equals("man")){	%>checked <%} %>> 남자
			<input type="radio" name="gender" value="woman" 
			<%if((mb.getGender()).equals("woman")){	%>checked <%} %>> 여자<br>
	이메일 :<input type="text" name="email" value="<%=mb.getEmail()%>"><br>
	<input type="submit" value="전송">
	<input type="button" value="뒤로" onclick="history.back()">
</form>




</body>
</html>