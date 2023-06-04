<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<link rel="stylesheet" href="css/reset.css" />
<style>
   
   .pHeader,
   .pBody .pItem {
      font-size: 0px;
      padding: 10px 0;
   }
   
   .pHeader > div,
   .pBody .pItem > div  {
      display: inline-block;
      font-size: 20px;
      text-align: center;
   }
   
   .pHeader {
      border-top: 2px solid blue;
      border-bottom: 1px solid #ccc;
   }
   
   .pHeader > div {
      font-weight: 600;
   }
   
   .pItem > div {
      vertical-align: middle;
   }
   
   .p_board_list .pItem {
      border-bottom: 1px solid #ccc; 
   }

   .p_board_list .pCategory, .p_board_list .pColor, .p_board_list .pCode {
      width: 13%;
   }
   
   .p_board_list .pPname, .p_board_list .pPrice {
      width: 18%;
   }
   
   .formSubmitDiv {
      display:flex;
      justify-content: space-between;
      margin-left: 35px;
   }

</style>

</head>
<body>
<div class="p_board_list">
   <div class="pHeader">
      <div class="pCode">상품코드</div>
      <div class="pCategory">카테고리</div>
      <div class="pPname">상품이름</div>
      <div class="pColor">상품색상</div>
      <div class="pPrice">상품가격</div>
   </div>
   
   <form class="pBody" action="adminProduct.do">
      <div class="pItem">
         <div class="pCode"><input type="text" name="code" placeholder="상품코드를 입력하세요." required></div>
         <div class="pCategory"><input type="text" name="category" placeholder="카테고리를 입력하세요." required></div>
         <div class="pPname"><input type="text" name="pname" placeholder="상품이름을 입력하세요." required></div>
         <div class="pColor"><input type="text" name="color" placeholder="상품색상을 입력하세요." required></div>
         <div class="pPrice"><input type="text" name="price" placeholder="상품가격을 입력하세요." required></div>
         <div class="formSubmitDiv">
            <input type="submit" value="SUBMIT">
            <input type="reset" value="CANCEL">
         </div>
      </div>
   </form>

</div>
</body>
</html>