<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
</head>
<body>

   <c:if test="${login == 2 }">
      <script>
         alert("로그인 성공")
         location.href = "index.jsp";
      </script>
   </c:if>
   
   <c:if test="${login == 3 }">
      <script>
         alert("관리자모드 접속")
         location.href="adminPage.jsp";
      </script>
   </c:if>
   
   <c:if test="${login < 1 }">
      <script>
         alert("아이디 혹은 비밀번호가 틀렸습니다.");
         location.href = "login.jsp";
      </script>
   </c:if>
   
</body>
</html>