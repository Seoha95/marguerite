<%@page import="vo.ShippingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>

<style>
	
	.mainDiv{
		display:flex;
		flex-direction: column;	
		align-items: center;
		width: 100%;
	}
	

	.topLogo{
		margin:150px 0px 100px 0px;
	}
	
	
	.topLogo > a{
		text-decoration-line: none;
		color:black;
	}
	
	.topLogo > a > span{
		
		font-size:30px;
		font-weight: 550;
		
	}
	
	.mainForm{
		display:flex;
		flex-direction: column;	
		align-items: center;
	}
	
	
	.mainForm > div > input{
	
		width: 400px;
		height: 35px;
		border : 2px solid rgba(0, 0, 0, 0.2);
	}

	.formSubmitDiv{
	
		width:400px;
		display:flex;
		align-items: center;
		justify-content: space-between;
		margin-top:20px;
		
	
	}
	
</style>

<script>
	
function Close() {
	opener.location.href = "userInfo.do";
	self.close();
}

</script>

</head>
<body>
<%
	String id = null;
	
	if(session.getAttribute("userID") != null) {
		id = (String) session.getAttribute("userID");
	}
		
%>
	<main class="mainDiv">
	
		<div class="topLogo"><a href="#"><span>배송지관리</span></a></div>

		<form class="mainForm" action="insertAddr.do">
				<div><input type="text" name="id" value="${userID }" readonly></div>
				<div><input type="text" name="address" placeholder="${shippingVO.address }" required></div>
				<div class="formSubmitDiv">
					<input type="submit" value="배송지입력">
					<input type="button" value="취소" onclick="location.href='userInfo.do'" />	
				</div>
		</form>
	</main>
	
</body>
</html>