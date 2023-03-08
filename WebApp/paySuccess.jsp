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
	

    <footer></footer>
</body>
</html>