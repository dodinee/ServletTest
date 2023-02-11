<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC1</title>
</head>
<%
pageContext.setAttribute("aa", "pagecontext aa");
pageContext.setAttribute("result", "pagecontext result"); /* result 우선순위 1 */
%>
<body>
	<%=request.getAttribute("result") %>입니다.<br>
	${result}	<!-- // el : Expression Language --><br>
	${names[0]} <br>
	${notice.title}<br>
	${aa}<br> <!-- pageContext로부터 가져옴 -->
	<br>
	${requestScope.result }<br> <!-- 스코프 지정 -->
	${result}<br>
	<br>
	${pram.n}<br> <!-- 파라미터 값 저장소  -->
	${header.accept }<br>
	<br>
	${pageContext.request.method }<br>
	<br>
	${empty pram.n ? 'param.n = empty' : param.n }<br> <!-- null || "" -->
</body>
</html>