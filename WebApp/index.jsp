<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.wrap {
	  position: relative;
	  min-height: 100%;
	  padding-bottom: 114px;
	  overflow:hidden;
	}
	
	.mainDiv{
		margin-bottom: 100px;
	}
   .mainPageImg {
      width: 100%;
      height: 500px;    
   }

   .titleSpan{
      font-size: 40px;
      font-weight: 550;
   }
   .titleDiv{
   		margin-top: 50px;
   		margin-left: 50px;
   }
   
   .mainPageNewProductDiv, .mainPageBestProductDiv{
      display:flex;
      align-items:center;
      margin-top:40px;
		overflow:hidden;
   }
   
   .mainPageNewProductDiv > div > img {
   
      width : 300px;
      height: 440px;
      margin: 0px 50px;
      border-radius: 10px;
   }
	
	.mainPageBestProductDiv > imageDiv{
		float:left;
		display:flex;
		flex-direction: column;
		align-items: center;
		margin-bottom: 120px;
		
	}
	
	.img{
		width: 280px;
		height: 420px;
		margin: 0px 50px;
     	
	}
	.pnameDiv{
		margin-top: 10px;
		margin-left: 50px;
	}
	
	.priceDiv{
		margin-top: 5px;
		margin-left: 50px;
	}
	   
</style>
<div class="wrap">
      <%@ include file="/set/header.jsp" %>
   <main class="mainDiv">
   
      <img class="mainPageImg"src="img/mainPageImg.jpg">
      
      <div class="titleDiv"><span class="titleSpan">신상품</span></div>
      
      <div class="mainPageNewProductDiv">
            
         <c:forEach var="nplist" items="${nplist}" begin="0" end="3"> 
         
         <form action="detailCheck.do"> 
         
            <input type="hidden" name="code" value="${nplist.code }" />
            <input type="hidden" name="category" value="${nplist.category }" />
            <input type="hidden" name="pname" value="${nplist.pname }" />
            <input type="hidden" name="psize" value="${nplist.psize }" />
            <input type="hidden" name="pimage" value="${nplist.pimage }" />
            <input type="hidden" name="price" value="${nplist.price }" />
            
            <div class="imageDiv">
               <div><input class="img" type="image" name=submit src="${nplist.pimage}"  /></div>
               <div class="pnameDiv"><span>${nplist.pname}</span></div>
               <div class="priceDiv"><fmt:formatNumber value="${nplist.price}" pattern="#,##0" />원</div>
            </div>
         </form>
         
      </c:forEach>
      
      </div>
      
      <div class="titleDiv"><span class="titleSpan">인기상품</span></div>
     <div class="mainPageBestProductDiv">
      <c:forEach var="plist" items="${plist}" begin="0" end="3"> 
         
         <form action="detailCheck.do"> 
         
            <input type="hidden" name="code" value="${plist.code }" />
            <input type="hidden" name="category" value="${plist.category }" />
            <input type="hidden" name="pname" value="${plist.pname }" />
            <input type="hidden" name="psize" value="${plist.psize }" />
            <input type="hidden" name="pimage" value="${plist.pimage }" />
            <input type="hidden" name="price" value="${plist.price }" />
            
            <div class="imageDiv">
               <div><input class="img" type="image" name=submit src="${plist.pimage}" /></div>
               <div class="pnameDiv"><span>${plist.pname}</span></div>
               <div class="priceDiv"><fmt:formatNumber value="${plist.price}" pattern="#,##0"/>원</div>
            </div>
         </form>
         
      </c:forEach>
        </div>
   </main>
   
<%@ include file="/set/footer.jsp" %>
</div>