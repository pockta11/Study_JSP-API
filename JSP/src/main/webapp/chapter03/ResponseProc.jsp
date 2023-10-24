<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<%
	// 고정으로 id 값을 붕
	String dbid = "soldesk";
	String dbpass = "12345";

	// request 객체에 저장되어 있는 id 값을 읽어옴
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	// 아이디 비번이 같다면 ResponseLogin.jsp 제어권을 넘김
	if ((id.equals(dbid)) && (pass.equals(dbpass))) {
		session.setAttribute("id", id); // session 영역(브라우저)에 저장
		response.sendRedirect("ResponseLogin.jsp");
		// Get방식
		// response.sendRedirect("ResponseLogin.jsp");
	} else {
	%>
	<script type="text/javascript">
		alert("아이디가 틀립니다.")
		history.go(-1);
	</script>
<!-- 	response.sendRedirect("Login.jsp"); -->
	<%
	}
	%>
</body>
</html>