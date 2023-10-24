<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" errPage="Error2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
	<%= response.setStatus(200) %>
	관리자에게 연결됩니다.
	<h2>죄송합니다. <%= exception.getMessage() %> 문제로 에러가 발생했습니다.</h2>
</body>
</html>