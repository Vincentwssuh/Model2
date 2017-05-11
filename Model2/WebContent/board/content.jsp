
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
	<%
		BoardBean bb = (BoardBean) request.getAttribute("bb");
		String pageNum = (String) request.getAttribute("pageNum");
		int num = ((Integer) request.getAttribute("num")).intValue();
	%>
	<h1>WebContent/board/content.jsp</h1>
	<h1>글내용보기</h1>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><%=bb.getNum()%></td>
			<td>조회수</td>
			<td><%=bb.getReadcount()%></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><%=bb.getName()%></td>
			<td>작성일</td>
			<td><%=bb.getDate()%></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td colspan="3"><%=bb.getSubject()%></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3">
				<%
					if (bb.getFile() != null) {
				%> <a href="../upload/<%=bb.getFile()%>"> <%=bb.getFile()%></a> <%
 	} else {
 %> 첨부파일 없음 <%
 	}
 %>
			</td>
		</tr>
		<tr>
			<td>글내용</td>
			<td colspan="3"><%=bb.getContent()%></td>
		</tr>
		<tr>
			<td colspan="4"><input type="button" value="글수정"
				onclick="location.href='BoardUpdate.bo?num=<%=num%>&pageNum=<%=pageNum%>'">
				<input type="button" value="글삭제"
				onclick="location.href = './BoardDelete.bo?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>'">
				<input type="button" value="답글쓰기"
				onclick="location.href = './BoardreWriteForm.bo?num=<%=num%>&re_ref=<%=bb.getRe_ref()%>&re_lev=<%=bb.getRe_lev()%>&re_seq=<%=bb.getRe_seq()%>'">
				<input type="button" value="글목록"
				onclick="location.href = './BoardList.bo?pageNum=<%=pageNum%>'"></td>
		</tr>
	</table>

</body>
</html>