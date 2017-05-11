
<%@page import="net.board.db.BoardDAO"%>
<%@page import="net.board.db.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Barrio"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List boardList = (List) request.getAttribute("boardList");
		int count = ((Integer) request.getAttribute("count")).intValue();
		String pageNum = (String) request.getAttribute("pageNum");
		int pageSize = ((Integer) request.getAttribute("pageSize")).intValue();
		int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	%>
	<h1 style="font-family: 'Barrio', cursive;">WebContent/board/list.jsp</h1>
	<h1>
		게시판 글목록 [ 전체글의 개수 :
		<%=count%>]
	</h1>
	<h3>
		<a href="./BoardWrite.bo">글쓰기</a>
	</h3>

	<table border="1">
		<tr
			style="background-color: green; text-align: center; font-size: 1.2em; font-weight: bold;">
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>ip</td>
		</tr>
		<%
			for (int i = 0; i < boardList.size(); i++) {
				BoardBean bb = (BoardBean) boardList.get(i);
		%>
		<tr>
			<td><%=bb.getNum()%></td>
			<td>
				<%
					//답글 들여쓰기 모양
						int wid = 0;
						if (bb.getRe_lev() > 0) {
							wid = 10 * bb.getRe_lev();
				%> <img src="board/level.gif" width="<%=wid%>"> <img src="board/re.gif">
				<%
					}
				%> <a href="./content.bo?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>"><%=bb.getSubject()%></a>
			</td>
			<td><%=bb.getName()%></td>
			<td><%=bb.getDate()%></td>
			<td><%=bb.getReadcount()%></td>
			<td><%=bb.getIp()%></td>
		</tr>
		
		<%
			}
		%>
	</table>
	<%
		if (count != 0) {
			//전체 페이지수 구하기 게시판 
			//글 50개 한화면에 보여줄 글개수 10개일경우 => 전체 5 페이지
			//글 56개 한화면에 보여줄 글개수 10개일경우 => 전체 6 페이지
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			//한 화면에 보여줄 페이지 번호 개수
			int pageBlock = 10;
			//시작페이지 번호 1~10 => 1    11~20 => 11   21~30 => 21
			int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
			//		1		  = ((     2          - 1)/pageBlock)*pageBlock+1;
			//		1		  = ((     9          - 1)/pageBlock)*pageBlock+1;
			//		11		  = ((     12          - 1)/pageBlock)*pageBlock+1;
			//		11		  = ((     19          - 1)/pageBlock)*pageBlock+1;
			//끝페이지 번호
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) {
				endPage = pageCount;
			}
			//이전
			if (startPage > pageBlock) {
	%><a href="./BoardList.bo?pageNum=<%=startPage - pageBlock%>">[이전]</a>
	<%
		}
			// 1~10
			for (int i = startPage; i <= endPage; i++) {
	%><a href="./BoardList.bo?pageNum=<%=i%>">[<%=i%>]
	</a>
	<%
		}
			//다음
			if (endPage < pageCount) {
	%><a href="./BoardList.bo?pageNum=<%=startPage + pageBlock%>">[다음]</a>
	<%
		}

		}
	%>
	<!-- 	1 2 3 .....10  [다음] -->
	<!-- 	[이전] 11 12 13 ... 20 [다음] -->
	<!-- 	[이전] 21 22 23 ..27   [다음] -->

</body>
</html>