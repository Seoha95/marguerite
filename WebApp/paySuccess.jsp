<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<link rel="stylesheet" href="css/style.css" />
<style>

	body{
		background-color: #F5F5DC;
	}
	
	

	.mainText{
		
		display: flex;
		flex-direction : column;
		justify-content: center;
		align-items: center;
		margin-top: 200px;
		width: 100%;
	
	}
	
	.mainText > div > p{
	
		font-size: 70px;
	
	}
	
	.mainText > div> a{
	
		font-size: 40px;
		color: black;
		text-decoration-line: none;
		padding : 5px;
		
	}
	
	.textDiv{
		
		display: flex;
		justify-content: space-around;
		width: 1000px;
		height: 30px;
	
	}
	

	

</style>

</head>
<body>
	
   <%@ include file="/set/header.jsp" %>
   
   <main class="mainText">
	    <div>
	        <p>결제가 완료 되었습니다</p>
	        <P>이용해 주셔서 감사합니다</P>
	    </div>
	    <div class="textDiv">
	    	<a class="myOrder" href="myOrderList.do">나의 주문내역</a> 
	    	<a class="home" href="index.jsp">홈으로</a> 
    	</div>
	</main>
	

    <%@ include file="/set/footer.jsp" %>
</body>
</html>