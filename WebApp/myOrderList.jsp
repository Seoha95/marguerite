<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>marguerite</title>
<style>

	body{
	
		height: 350vh;
		background-color: #F5F5DC;
	}
	
	header{
		background-color: #E4E5CA;
		padding: 40px 0;
	}
	
	.headerArea{
		display:flex;
		align-items:center;
		margin-top:5px;
	}
	
	.headerArea > div{
		margin: 0px 20px;
		display:flex;
	}
	
	
	.headerArea > div > a{
		color: black;
		text-decoration-line: none;
	}
	
	
	.headerArea > div > a > span{
		font-size:30px;
		font-weight: 550;
	}
	
	.topText{
		margin: 50px 0 0 40px;
	}
	
	.topText > span{
	
		font-size:60px;
		font-weight: 600;
	}
	
	hr{
		margin-top : 20px;
		border:1px solid;
	
	}
	
	.orderListDiv{
	
		background-color : #E7E2BA;
		border : 1px #F5F5DC;
		border-radius: 14px;
		margin:40px;
		width: 80%;
		padding: 15px 0 20px 0;
	
	}
	
	img{
		width: 180px;
		height: 180px;
		border-radius: 14px;
		margin: 0 30px 0 40px;


	}
	
	.paymentText{
		margin: 10px 0 10px 40px;
	}
	.paymentText > span{
		font-size: 30px;
		font-weight: 550;
	}
	
	.orderInfoDiv{
		
		width:90%;
		display:flex;
		justify-content: flex-start;
	}
	
	.orderInfoRightDiv {
		margin-top:20px;
	}
	
	.orderInfoRightDiv > div{
		margin-bottom:4px;
	}
	
	.orderInfoRightDiv > div > span{
		font-size : 25px;
	}
	
</style>


</head>
<body>
	<header>
		<div class="headerArea">
				
			<div><a href="./"><span>marguerite</span></a></div>
			<div><a href="best.do"><span>best</span></a></div>
			<div><a href="outer.do"><span>outer</span></a></div>
			<div><a href="top.do"><span>top</span></a></div>
			<div><a href="bottom.do"><span>bottom</span></a></div>
			<div><a href="shoes_bag.do"><span>shoes&bag</span></a></div>
			<div><a href="dress.do"><span>dress</span></a></div>
			<div>
				<form action="search.do" >
					<input type="text" name="searchItem"/>
					<input type="submit" value="search" />
				</form>
			</div>
			<%
					int login = 0;
	
				if (session.getAttribute("login") != null) {
					login = (int) session.getAttribute("login");
				}
	
				if (login == 3) {
				%>
	
				<div>
					<a href="adminPage.jsp"><span>관리자</span></a>
				</div>
				<div>
					<a href="logout.do"><span>로그아웃</span></a>
				</div>
				<%
					}else if(login == 2){
				%>
	
				<div>
					<a href="userInfo.do"><span>유저정보</span></a>
				</div>
				<div>
					<a href="logout.do"><span>로그아웃</span></a>
				</div>
				<div><a href="basket.do"><span>장바구니</span></a></div>
				<%
					}else{
				%>
					<div>
						<a href="login.jsp"><span>로그인</span></a>
					</div>
					<div><a href="basket.do"><span>장바구니</span></a></div>
				<% } %>
				
		</div>
	</header>	
	
	<main class="mainDiv">
	
		<div class="topText"><span>주문내역</span></div>
		<hr>
		<div>
			<c:forEach var="plist" items="${plist}">
				<div class="orderListDiv">
					<div class="paymentText"><span>결제완료</span></div>
					<div class="orderInfoDiv">
						<div><img src="${plist.pimage }" /></div>						
						<div class="orderInfoRightDiv">
							<div><span>${plist.pname }</span></div>
							<div><span>${plist.price }</span></div>
							<div><span>주문수량 : ${plist.count }</span></div>
							<div><span>사이즈 : ${plist.psize }</span></div>
						</div>
					</div>
				</div>		
			</c:forEach>
		</div>
	</main>

	
</body>
</html>