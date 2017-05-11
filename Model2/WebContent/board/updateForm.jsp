
<%@page import="net.board.db.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 글수정</h1>

	<%
		
		int num = ((Integer)request.getAttribute("num")).intValue();
		String pageNum = (String)request.getAttribute("pageNum");

		BoardBean bb = (BoardBean)request.getAttribute("bb");
		
	%>
	
<form action="./BoardUpdateAction.bo?pageNum=<%=pageNum %>" method="post" name="fr">
	<input type="hidden" name="num" value="<%=bb.getNum()%>">
	글쓴이 :	<input type="text" name="name" value="<%=bb.getName()%>" readonly><br>
	비밀번호 : <input type="password" name="pass"><br>
	제목 :	<input type="text" name="subject" value="<%=bb.getSubject()%>"><br>
	내용 :	<textarea rows="" cols="" name="content"><%=bb.getContent()%></textarea>
<input type="submit" value="글쓰기">
</form>
</body>
</html>