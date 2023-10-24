<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>06.Forward_Action</title>
</head>
<body>
	<h2>forward_Action.jsp 에서 footer.jsp 호출</h2>
	<hr>
	Forward_Action.jsp 의 모든 내용은 출려되지 않습니다.
	<%! int a = 10;%>
	<jsp:forward page="footer.jsp">
		<jsp:param name="email" value="test@test.com"/>
		<jsp:param name="phone" value="010-1234-1234"/>
	</jsp:forward> <br>
	<%= a %>
	<h2>감사합니다.</h2>
	
</body>
</html>