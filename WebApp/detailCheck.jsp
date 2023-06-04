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
<title>marguerite</title>
<style>
	body{
		height: 350vh;
		background-color: #F5F5DC;
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

<%@ include file="/set/header.jsp" %>
	
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


<%@ include file="/set/footer.jsp" %>
</body>
</html>