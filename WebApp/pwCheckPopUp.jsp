<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	
function Close() {
	opener.location.href = "login.jsp";
	self.close();
}

</script>

</head>
<body onbeforeunload="Close()">

	<%
		session = request.getSession();
		String pw = (String) session.getAttribute("findPw");
		String id = (String) session.getAttribute("findId");
	%>
	
	<%=id %>님의 비밀번호는 <%=pw %> 입니다!
	
</body>
</html>