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
      margin:150px 0px 130px 0px;
      color:black;
   }
   
   
   .topLogo >  span{
      
      font-size:50px;
      font-weight: 550;
      
   }
   
   .adminMethodDiv{
   
      display:flex;
      justify-content: space-around;
      width: 50%;
   
   }
   
   .memberDiv, .orderDiv, .productDiv {
   
      width: 300px;
      height: 400px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background-color: #F5F5DC;
      box-shadow: 0 0 3px 0;   
      border-radius: 20px;
      cursor: pointer;
   }
   
   .memberDiv > a > span, .orderDiv > a > span, .productDiv > a > span {
      font-size: 30px;
      font-weight: 550;
   }
   
   a {
      text-decoration: none;
      color: inherit;
   }
   
</style>
</head>
<body>

   <main class="mainDiv">
   
      <div class="topLogo"><span>관리자모드</span></div>
      
      <div class="adminMethodDiv">
         <div class="memberDiv"><a href="adminMember.do"><span>회원정보</span></a></div>
         <div class="orderDiv"><a href="adminOrder.do"><span>주문정보</span></a></div>
         <div class="productDiv"><a href="adminProduct.jsp"><span>상품등록</span></a></div>
      </div>
   </main>

</body>
</html>