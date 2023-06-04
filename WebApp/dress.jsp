<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
.wrap {
	  position: relative;
	  min-height: 100%;
	  padding-bottom: 114px;
	  overflow:hidden;
	}
	.mainDiv{
		margin-top: 50px;
		width:100%;
		overflow:hidden;
		padding-top: 10px;
		
	}
	
	.imageDiv{
		float:left;
		display:flex;
		flex-direction: column;
		margin-bottom: 100px;
		
	}
	
	.img{
		width: 280px;
		height: 420px;
		padding-left: 80px;
	}
	
	.pnameDiv{
		margin-top: 10px;
		margin-left: 80px;
	}
	
	.priceDiv{
		margin-top: 5px;
		margin-left: 80px;
	}
	
</style>
<div class="wrap">
	<%@ include file="/set/header.jsp" %>
	<main class="mainDiv">
		<c:forEach var="plist" items="${plist}"> 
			
			<form action="detailCheck.do"> 
			
				<input type="hidden" name="code" value="${plist.code }" />
				<input type="hidden" name="category" value="${plist.category }" />
				<input type="hidden" name="pname" value="${plist.pname }" />
				<input type="hidden" name="psize" value="${plist.psize }" />
				<input type="hidden" name="pimage" value="${plist.pimage }" />
				<input type="hidden" name="price" value="${plist.price }" />
				
				<div class="imageDiv">
					<div><input class="img" type="image" name=submit src="${plist.pimage}"  /></div>
					<div class="pnameDiv"><span>${plist.pname}</span></div>
					<div class="priceDiv"><fmt:formatNumber value="${plist.price}" pattern="#,##0" />원</div>
				</div>
			</form>
			
		</c:forEach>
	</main>
	
	<%@ include file="/set/footer.jsp" %>
</div>	