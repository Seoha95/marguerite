<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문</title>
<link rel="stylesheet" href="css/style.css" />
<style>

.sHeader,
.sBody .sItem {
	font-size: 0px;
	padding: 10px 0;
}


.sHeader > div,
.sBody .sItem > div  {
	display: inline-block;
	font-size: 14px;
	text-align: center;
}

.sHeader {
	border-top: 2px solid blue;
	border-bottom: 1px solid #ccc; 
}
.sHeader > div {
	font-weight: 600;
}

.sItem > div {
	vertical-align: middle;
}


.s_board_list .sItem {
	border-bottom: 1px solid #ccc; 
}

.s_board_list .sId{
	width: 10%;
}

.s_board_list .sPimage{
	width: 10%;
}

.s_board_list .sCount{
	width: 15%;
}

.s_board_list .sPsize{
	width: 10%;
}

.s_board_list .sPrice{
	width: 55%;
}

#sPimage {
	width: 150px;
	height: 200px;
}

</style>

</head>
<body>
<div class="s_board_list">
	<div class="sHeader">
		<div class="sId">아이디</div>
		<div class="sPimage">상품이미지</div>
		<div class="sCount">수량</div>
		<div class="sPsize">사이즈</div>
		<div class="sPrice">가격</div>
	</div>
	
	<div class="sBody">
		<c:forEach var="oli" items="${plist}">
			<div class="sItem">
				<div class="sId">${oli.id}</div>
				<div class="sPimage" ><img src="${oli.pimage}" id="sPimage"/></div>
				<div class="sCount">${oli.count}</div>
				<div class="sPsize">${oli.psize}</div>
				<div class="sPrice">${oli.price}</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>