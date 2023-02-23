<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>
<title>Insert title here</title>
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
	
	.mainDiv{
	
		display:flex;
		align-items:center;
		justify-content:center;
		margin-top:120px;
	
	}
	
	.mainImageDiv > img{
		
		width: 400px;
		height: 650px;
		border-radius: 40px;
	
	}
	
	
	
	.mainSpanForm{
		margin-left: 40px;
		width: 400px;
		height: 650px;
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		
	}
	
	.nameDiv{
		height: 20%;
	}
	
	.nameDiv, .priceDiv, .deliveryFeeDiv, .sizeDiv, .totalPriceDiv, .countDiv{
	
		display:flex;
		justify-content: space-between;
	}
	
	.nameDiv > input{
		width:700px;
		font-size: 25px;
		font-weight: 650;
		border:0 solid black;
		background-color:#F5F5DC;
	}
	
	.priceDiv >span , .deliveryFeeDiv > span, .sizeDiv > span, .totalPriceDiv > span, .countDiv > div > span{
		font-size:18px;
		font-weight: 600;
	
	}
	
	.priceDiv > input, .deliveryFeeDiv > input , .totalPriceDiv > input{
	
		text-align: right;
		font-size:18px;
		font-weight: 600; 
		border:0 solid black;
		background-color:#F5F5DC;
	}
	
	
	
	.count{
		font-size:18px;
		font-weight: 600; 
		width: 20px;
		text-align: center;
		border:0 solid black;
		background-color:#F5F5DC;
		margin : 0 5px;
	}
	
	.plusBox, .minusBox{
		
		cursor:pointer;
	
	}
	
	
	
	
	.submitDiv{
		display:flex;
		justify-content: space-between;
	}
	
	.submitDiv > input{
	
		width: 180px;
		height: 50px;
		font-size:18px;
		font-weight: 600;
	
	}
	
	hr{margin:30px 0px;}
	
	.footerFirstDiv > span{
		font-size:30px;
		font-weight: 300px;
		margin-right: 60px;
		margin: 0px 60px 50px 0px;
	}
	
	.footerSecondDiv > span{
		font-size:30px;
		font-weight: 300px;
	}
	
	
</style>

<script>
	
	function plus(){
		
		var count = document.getElementById("count");
		var deliveryFee = document.getElementById("deliveryFee");
		var price = document.getElementById("price");
		var totalPrice = document.getElementById("totalPrice");
		
		count.value++;
		
		totalPrice.value = parseInt(price.value) * parseInt(count.value) + parseInt(deliveryFee.value);
		
	}
	
	function minus(){
		
		var count = document.getElementById("count");
		if(count.value > 1){
			count.value--;
			totalPrice.value = parseInt(totalPrice.value) - parseInt(price.value);
		}else{
			count.value = 1;
		}
		
	}
	
	
	function routeSetting(path){
		
		var form = document.form;
		
		if(path == "1"){
			
			form.action="basket.do";
			
		}
		else if(path == "2"){
			
			form.action="payment.do";
			
		}		
		
		form.submit();
	}
	
	

</script>
</head>
<body>

	<%
		ProductVO plist = (ProductVO) request.getAttribute("plist");
	%>

	<header>
		<div class="headerArea">
				
			<div><a href="#"><span>marguerite</span></a></div>
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
	
			<div class="mainImageDiv">
				<img src="${plist.pimage}" />
			</div>
			
			<form action="payment.do" class="mainSpanForm" name="form" >
			
				<input type="hidden" name="pimage" value="${plist.pimage }" />
				<input type="hidden" name="code" value="${plist.code }" />
				<input type="hidden" name="category" value="${plist.category }" />
			
				<div class="nameDiv">
					<input type="text" name="pname" value="${plist.pname }" readonly/>
				</div>
				<div class="priceDiv">
					<span>가격</span>
					<input type="text" name="price" id="price" value="${plist.price }" readonly/>
				</div>
				<div class="deliveryFeeDiv">
					<span>배송비</span>
					<input type="text" name="deliveryFee" id="deliveryFee" value="2500" readonly />
				</div>
			<div class="sizeDiv">
               <span>사이즈</span>
               <select class="sizeBox" name="psize">
               <c:choose>
                  <c:when test="${plist.category eq 'shoesbag'}">
                     <option value="free">free</option>
                  </c:when>
                  <c:otherwise>
                     <option value="small">small</option>
                     <option value="medium" selected>medium</option>
                     <option value="large">large</option>
                  </c:otherwise>
               </c:choose>   
               </select>
            </div>
				<div class="countDiv">
					<div><span>수량</span></div>
					<div>
						<span class="minusBox" onclick="minus()">-</span>
						<input class="count" id="count" type="text" name="count" value="1" max="10" />
						<span class="plusBox" onclick="plus()">+</span>
					</div>
				</div>
				<div class="totalPriceDiv">
					<span>총 상품금액</span>
					<input type="text" name="totalPrice" id="totalPrice" value="${plist.price+2500 }" readonly/>
				</div>
				<div class="submitDiv">
					<input type="button" name="basketBtn" value="장바구니 담기" onclick="routeSetting('1')"/>
					<input type="button" name="paymentBtn" value="지금 구매" onclick="routeSetting('2')"/>
				</div>
			</form>
	</main>


	<footer>
	
	
		<hr>
	
		<div class="footerFirstDiv">
			<span>로고</span>
			<span>010-xxxx-xxxx</span>
			<span>공식sns</span>
		</div>
	
		<div class="footerSecondDiv">
			<span>서울특별시 마포구 동교로23길 32-23</span>
		</div>	
	</footer>
</body>
</html>