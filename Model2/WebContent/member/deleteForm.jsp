<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>deleteForm.jsp</h1>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");

		if (id == null) { //세션이 없으면 로그인 페이지로.
			response.sendRedirect("./Main.me");
		}
	%>


	<form action="./MemberDeleteAction.me" method="post">
		아이디 삭제를 위해서는 비밀번호 재입력이 필요합니다.<br>
		아이디 : <input type="text" name="id" value="<%=id%>" readonly><br>
		비밀번호 : <input type="password" name="pass"><br>
		<input type="submit" value="확인">
	</form>


</body>
</html>