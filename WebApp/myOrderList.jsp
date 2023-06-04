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
<%@ include file="/set/header.jsp" %>	
	
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

<%@ include file="/set/footer.jsp" %>
	
</body>
</html>