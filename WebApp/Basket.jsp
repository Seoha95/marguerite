<%@page import="vo.BasketVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<style>

	header{
      background-color: #E4E5CA;
      padding-top: 10px;
      padding-bottom: 30px;
      
      
   }

   .headerArea{
      display:flex;
      align-items:center;
      margin-top:25px;
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

	.cartHeader{
		margin-top: 100px;
		border-top: 2px solid blue;
		border-bottom: 1px solid #ccc; 
	}

	.cartHeader,
	.cartBody .cartItem{
		font-size: 0px;
		padding: 10px 0;
	}
	
	.cartHeader > div,
	.cartBody .cartItem > div {
	display: inline-block;
	font-size: 14px;
	text-align: center;
	
	}
	.cartHeader > div {
		font-weight: 600;
	}

	.cart_list .cartItem{
		border-bottom: 1px solid #ccc; 
	}
	
	.cart_list .check{
		width: 5%;
	}
	.cart_list .pimage{
		width: 10%;
	}
	.cart_list .pname{
		width: 25%;
	}
	.cart_list .psize{
		width: 10%;
	}
	.cart_list .count{
		width: 10%;
	}
	.cart_list .price{
		width: 10%;
	}
	.cart_list .deliveryFee{
		width: 10%;
	}
	.cart_list .manage{
		width: 10%;
	}
	.cart_list .pimage{
		width: 10%;
	}
	
	.cart_list .cartBody .pname{
		text-align: left;
	}
	.cartBody .cartItem > div{
		vertical-align: middle;
	}
	
   #simage{
      width: 150px; 
      height: 200px;
   }   
   
	.cartFooter{
		margin-top: 100px;
		border-top: 2px solid black;
		border-bottom: 1px solid #ccc; 
		
	}
	
	.cartFooter > div {
		font-weight: 600;
		
	}
	
	.cartTot {
		border-bottom: 2px solid black; 
	}
	
	.cartFooter,
	.cartTot {
		font-size: 0px;
		padding: 10px 0;
	}
	
	.cartFooter > div,
	.cartTot > div {
		display: inline-block;
		font-size: 14px;
		text-align: center;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	 
	
	.cartList2 .totPrice {
		width: 20%;
	}
	.cartList2 .totDeliveryFee {
		width: 20%;
	}
	.cartList2 .totFee {
		width: 60%;
	}
      
   .count >input,
   .price > input,   
   .totPrice > input, 
   .totDeliveryFee > input,
   .totFee > input{
   		border:0 solid black;
   		text-align: center;
   
   }   
   .submitDiv{
   		text-align: center;
   		margin-top: 30px;
      /* display:flex;
      justify-content: space-between; */
   }
   
   .submitDiv > input{
   
      width: 180px;
      height: 50px;
      font-size:18px;
      font-weight: 600;
      
   
   }
   
</style>

</head>

<script>

var sum = 0;
function calc(cBox) {
   if(cBox.checked)
      sum += parseInt(cBox.value);
   else{
      sum -= parseInt(cBox.value);
   }
   document.getElementById("totalSangPum").value = sum;
   document.getElementById("payment").value = sum+2500;
   
}


function routeSetting(path){
   
   var form = document.form;
   
   if(path == "1"){
      
      form.action="basketDelete.do";
      
   }
   else if(path == "2"){
      
      form.action="payment.do";
      
   }      
   
   form.submit();
}


</script>


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
   
            if (login != 2) {
            %>
   
            <div>
               <a href="login.jsp"><span>로그인</span></a>
            </div>
            <%
               } else {
            %>
   
            <div>
               <a href="userInfo.do"><span>유저정보</span></a>
            </div>
            <div>
               <a href="logout.do"><span>로그아웃</span></a>
            </div>
            <%
               }
            %>
         <div><a href="basketList.do"><span>장바구니</span></a></div>
         
      </div>   
   </header>
	<div class="cart_list">
   <div class="cartHeader">
   	  <div class="check"></div> 	
      <div class="pimage">이미지</div>
      <div class="pname">상품명</div>
      <div class="psize">사이즈</div>
      <div class="count">수량</div>
      <div class="price">구매금액</div>
      <div class="deliveryFee">배송비</div>
      <div class="manage">주문관리</div>
   </div>
   
   <c:if test="${plist eq null or empty plist}">
      <h3 style="text-align: center;"><b>담긴 상품이 없습니다.</b></h3>
   </c:if>
         
   <form action="payment.do" name="form">
   <div class="cartBody">	
      <c:forEach var="plist" items="${plist}">
         <div class="cartItem">
               <div class="check"><input type="checkbox" name="OneCheck"  id="OneCheck" value="${plist.price}" onclick="calc(this)"/></div>
               <div class="pimage"><img src="${plist.pimage}" id="simage" /></div>
               <div class="pname">${plist.pname}</div>
               <div class="psize">${plist.psize}</div>
               
               <input type="hidden" name="pimage" value="${plist.pimage }" />
               <input type="hidden" name="code" value="${plist.code }" />
               <input type="hidden" name="category" value="${plist.category }" />
               <input type="hidden" name="pname" value="${plist.pname }" />
               <input type="hidden" name="psize" value="${plist.psize }" />
         
            <div class="count">
                   <span class="minusBox" onclick="location.href='basketCountDown.do?pname=${plist.pname}&psize=${plist.psize}'">-</span>
                   <input class="count" id="count" type="text"  size="2" name="count" value="${plist.count}" max="10" />
                   <span class="plusBox" onclick="location.href='basketCountUp.do?pname=${plist.pname}&psize=${plist.psize}'">+</span>
            </div>
            <div class="price"><input type="text" name="totalPrice" id="totalPrice" value="${plist.price}" size="8" /></div>
            <div class="deliveryFee">2500</div>
            <div class="manage"><input type="button" onclick="routeSetting('1')"  value="삭제"/></div>
            <input type="hidden" name="price" value="${plist.price }" />
         </div>
      </c:forEach>
      </div>	
      </div>
      <div class="cartList2">
	      <div class="cartFooter">
	         <div class="totPrice">총 상품금액</div>
	         <div class="totDeliveryFee">총 배송비</div>
	         <div class="totFee">결제예정금액</div>
	      </div>
	      <div class="cartTot">
	         <div class="totPrice"><input type="text" id="totalSangPum" value="0" size="10" /></div>
	         <div class="totDeliveryFee"><input type="text" value="2500" size="10"/></div>
	         <div class="totFee"><input type="text" name="totalPrice" id="payment" value="0" size="10"/></div>
	      </div>
      </div>
      <div class="submitDiv" >
         <input type="button" name="paymentBtn" value="결제하기" onclick="routeSetting('2')"/>
      </div>
      </form>
</body>
</html>