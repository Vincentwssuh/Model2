<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>jstl/jstl_core.jsp</h1>

	<%
		//JSTL(JSP Standard Tag Lombray)

		//http://jakarta.apache.org

		//자바 코드를 최대한 줄이기 위해 제공된 태그.
		//자주사용되는 필요한 기능을 모아 놓은 커스텀 태그
		//코드를 간결하게 해주고 (분리되는 부분이 작으므로) 가득성이 높다.
		//프로그램 설치 standard.jar, jstl.jar

		// core	fmt	xml	sql
	%>

	<c:set var="test" value="JSTL TEST" />
	<!-- 	var은 변수이름 -->
	<!-- value는 변수 값 -->


	변수 선언 후 :
	<c:out value="${test }" />
	<br>
	<!-- 변수 출력시 에는 value안에 var값을 넣어준다. -->


	변수 삭제
	<c:remove var="test" />
	<br> 변수 삭제 후 :
	<c:out value="${test }" />



	<c:catch var="err">
		<%=10 / 0%>
	</c:catch>
	catch로 잡은 오류(try catch처럼) :
	<c:out value="${err }" />
	<br>



	<c:if test="${5<10 }">
		5는 10보다 작다.<br>
	</c:if>
	<c:if test="${5>10 }">
		5는 10보다 크다.<br>
	</c:if>
	<!-- 	if문은 참인 조건 동작만 가능하다.(else가 없음.) -->

	<c:choose>
		<c:when test="${5+10==50 }">
			5+10은 50이다.
		</c:when>
		<c:otherwise>
			if문의 else처럼 사용 가능한 부분.
		</c:otherwise>
	</c:choose>
	<br>


	<c:forEach var="i" begin="1" end="10" step="2">
		<!-- 	1부터 2간격으로 10까지 -->
		${i }
	</c:forEach>
	<br>

	<!-- forTokens ! 많이 사용한다. ! -->
	<c:forTokens var="st" items="a,b,c,d,e,f,g" delims=",">
		<!-- 	,로 구분된 것을 사용하겠다. -->
		${st }
	</c:forTokens>
	<br>

	<c:set var="data" value="홍길동, 이순신, 유관순" />
	<c:forTokens var="st_var" items="${data }" delims=",">
		${st_var }<br>
	</c:forTokens>
	<br>

</body>
</html>