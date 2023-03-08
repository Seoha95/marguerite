<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.UserVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<style>

	body{
		display:flex;
		justify-content: center;
		align-items: center;
		background-color: #F5F5DC;
	}
	
	
	
	main{
		border:1px solid rgba(0, 0, 0, 0.2);
		width: 60%;
		height: 800px;
		margin-top: 100px;
		border-radius: 100px;	
		box-shadow: 0 0 5px 0;	
	}
	
	.logoDiv{
		margin:50px 0 0 70px;
		cursor:pointer;
	}
	
	.logoDiv >span{
		font-size:40px;
		font-weight: 550;
	}

	.userInfoDiv{
		
		display:flex;
		margin-top: 50px;
		width: 100%;
		margin-left: 70px;
	}
	
	.userNameDiv{
	
		display:flex;
		flex-direction: column;
		align-items: flex-start;
	
	}
	
	.userImg{
	
		width : 120px;
		height : 120px;
		border-radius: 50%;
		margin-right: 20px;
		
	}
	
	.userName{
		width : 100%;
		font-size:50px;
		font-weight: 600;
	}
	
	.userID{
		
		width: 100%;
		font-size:30px;
	}
	
	.userTelDiv{
		margin: 50px 0 0 70px;
		display:flex;
		width: 100%;
	}
	
	.userTelDiv > div{
		margin-right: 10px;
	}
	
	.userTelDiv > div > span{
		font-size:20px;
		font-weight: 550;
	}
	
	.userShipDiv{
		margin: 10px 0 0 70px;
		display:flex;
		width: 100%;
	}
	
	.userShipDiv > div{
		margin-right: 10px;
	}
	
	.userShipDiv > div > span{
		font-size:20px;
		font-weight: 550;
	}
	
	.deliveryInfo, .pwInfo, .orderListInfo{
		
		background-color : #E5E4CF;
		margin: 50px 0 0 70px;
		border:1px solid rgba(0, 0, 0, 0.2);
		width: 80%;
		height: 50px;
		border-radius: 10px;
		display:flex;
		align-items: center;
		box-shadow: 0 0 2px 0;
		
	}

	.deliveryInfo > span, .pwInfo > span, .orderListInfo > span{
		font-size: 25px;
		font-weight: 600;
		margin: 0 20px;
		cursor: pointer;
	}
	
	.logoutDiv{
	
		display:flex;
		height: 130px;
		justify-content: center;
		align-items: flex-end;
	}
	
	.logoutDiv > div{
	
		margin:0 3px;
		cursor : pointer;
	
	}
	
	
	
	
</style>

</head>
<body>

	
	<main>
	 		<div class="logoDiv">
	 			<span onclick="location.href='index.jsp'">marguerite</span>
	 		</div>
	 			
	 		<div class="userInfoDiv">
	 			<div>
	 				<img class="userImg" src="./img/mainPageImg.jpg"/>
	 			</div>
	 			<div class="userNameDiv">
	 				<div><span class="userName">${userVO.name }</span></div>
	 				<div><span class="userID">${userVO.id }</span></div>
	 			</div>
	 		</div>
	 		
	 		<div class="userTelDiv">
	 			<div><span>연락처</span></div>
	 			<div><span>${userVO.tel }</span></div>
	 		</div>
	 		
	 		<div class="userShipDiv">
	 			<div><span>배송지</span></div>
	 			<div><span>${shippingVO.address }</span></div>
	 		</div>
	 		
	 		<div class="pwInfo">
	 			<span onclick="location.href='updatePw.jsp'">비밀번호 변경</span>
	 			<p>현재 사용자의 비밀번호를 변경할 수 있습니다.</p>
	 		</div>
	 		
	 		<div class="deliveryInfo">
	 			<span onclick="location.href='shippingPopUp.do'">배송지 관리</span>
	 			<p>쇼핑, 예약 등에서 사용하신 배송지를 관리할 수 있습니다.</p>
	 		</div>
	 		
	 		<div class="orderListInfo">
	 			<span onclick="location.href='myOrderList.do'">주문내역 확인</span>
	 			<p>나의 주문내역을 확인할 수 있습니다.</p>
	 		</div>
	 		
	 		<div class="logoutDiv">
	 			<div onclick="location.href='logout.do'"><span>로그아웃</span></div>
	 			<div><span>|</span></div>
	 			<div onclick="location.href='index.jsp'"><span>홈으로</span></div>
	 		</div>
	 		
	 		
 	</main>
</body>
</html>