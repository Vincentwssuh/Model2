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
		// 글번호		제목		re_ref(그룹번호)		 re_lev(들여쓰기)		re_seq(답글순서)
		//		1		제목1				1							0						0
		//		4		 답1_2				1							0+1=1				0+1=1
		//		2		 답1_1				1							0+1=1				0+1=1+1=2 앞에 글이 생길 경우 +1
		//		3		  답1_1_1			1							1+1=2				1+1=2+1=3
		//	num		re_ref		re_lev		re_seq 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		int re_ref = Integer.parseInt(request.getParameter("re_ref"));
		int re_lev = Integer.parseInt(request.getParameter("re_lev"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
	%>
	<h1>WebContent/board/reWriteForm.jsp</h1>
	<h1>게시판 답글쓰기</h1>

	<form action="./BoardreWriteAction.bo" method="post" name="fr">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="re_ref" value="<%=re_ref%>">
		<input type="hidden" name="re_lev" value="<%=re_lev%>">
		<input type="hidden" name="re_seq" value="<%=re_seq%>">
		글쓴이 : <input type="text" name="name"><br> 
		비밀번호 : <input type="password" name="pass"><br> 
		제목 : <input type="text" name="subject"><br> 
		내용 : <input type="text" name="content"><br>
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>