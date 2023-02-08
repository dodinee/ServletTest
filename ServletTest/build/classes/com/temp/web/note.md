
post

전달하는 값들 Url에 미노출


응답 인코딩 지정 
resp.setCharacterEncoding("UTF-8");

응답 컨텐츠 타입 지정, 문자집합 지정 
resp.setContentType("text/html; charset=UTF-8");

요청 인코딩 지정 
req.setCharacterEncoding("UTF-8");

서블릿마다 넣는건 비효율적
동일한 url 서블릿에 공통 적용될 사항이며,
서블릿 사전/사후 모두 적용되는 부분

== 필터 활용


1. 어노테이션 적용 방법 (@WebFilter("url지정")) 
2. web.xml 적용 방법





Servlet Context : 상태 저장 공간, 자원을 공유하는 공간 





- Application 객체 : application 전역에서 사용 가능 
				   : WAS의 시작과 종료까지 WAS의 메모리에 저장
				   
- Session 객체 : session 범주에서 사용 가능 = 현재 접속 사용자 개별공간 (WAS의 메모리)
	 		   : 한번 방문 시 WAS로부터 SID가 부여됨 = 세션공간 생김 = 브라우저 닫으면 폐기
	 		   
void setAttribute(String name, Object value) : 지정된 이름으로 객체 설정 
Object getAttribute(String name) : 지정한 이름의 객체 반환 
void invalidate() : session 에서 사용중인 객체들 해제 
	 
void setMaxInactiveInterval(int interval) : set session timeout (default = 30minutes)
boolean isNew()
Long getCreationTime() : start request from 1970/01/01 millisec
long getLastAccessedTime() : last request time from 1970/01/01 milisec




- Cookie : 클라이언트가 가지고있는 상태값 
		 : Browser에 전달한 시간부터 만료시간까지, Browser memory or file 
		 : 사용 기간이 길 경우 Cookie에 저장 
		 : 특정 범위, 특정 경우에 쓰이는 데이터의 경우 Cookie에 저
		 
getHeader("remote-host") : header info
getParameter("x") : user data
Cookie[] getCookies()
addCookies() : save at client

setPath("url")
setMaxAge() : set expiration sec







