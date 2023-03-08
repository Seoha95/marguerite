<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>

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
		String id = (String) session.getAttribute("findId");
		String name = (String) session.getAttribute("findName");
	%>
	
	<%=name %>님의 ID는 <%=id %> 입니다!
	
	
		

</body>
</html>