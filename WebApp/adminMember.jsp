<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<link rel="stylesheet" href="css/style.css" />
<style>

.memHeader,
.memBody .memItem {
	font-size: 0px;
	padding: 10px 0;
}


.memHeader > div,
.memBody .memItem > div  {
	display: inline-block;
	font-size: 14px;
	text-align: center;
}

.memHeader > div {
	font-weight: 600;
}

.memHeader {
	border-top: 2px solid blue;
	border-bottom: 1px solid #ccc; 
}

.mem_board_list .memItem {
	border-bottom: 1px solid #ccc; 
}

.mem_board_list .memId{
	width: 10%;
}

.mem_board_list .memPw{
	width: 10%;
}

.mem_board_list .memTel{
	width: 15%;
}

.mem_board_list .memName{
	width: 10%;
}

.mem_board_list .memAddr{
	width: 55%;
}



</style>

</head>
<body>

	<div class="mem_board_list">
		<div class="memHeader">
			<div class="memId">아이디</div>
			<div class="memPw">비밀번호</div>
			<div class="memTel">전화번호</div>
			<div class="memName">이름</div>
			<div class="memAddr">주소</div>
		</div>
	
		<div class="memBody">
			<c:forEach var="uli" items="${ulist}">
			<div class="memItem">
				<div class="memId">${uli.id}</div>
				<div class="memPw">${uli.pw}</div>
				<div class="memTel">${uli.tel}</div>
				<div class="memName">${uli.name}</div>
				<div class="memAddr">${uli.address}</div>
			</div>
			</c:forEach>
		</div>
	</div>
	

</body>
</html>