<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>
<link rel="stylesheet" href="css/style.css" />
<style>

	body{
	
		height: 350vh;
		background-color: #F5F5DC;
	}
	
	


	
	.mainDiv{
		width:1800px;
		margin: 100px auto;
		overflow:hidden;
		padding-top: 10px;
		
		
	}
	
	.imageDiv{
		float:left;
		display:flex;
		flex-direction: column;
		align-items: center;
		margin-bottom: 120px;
		
	}
	
	.img{
		width: 300px;
		height: 440px;
		margin: 0px 50px;
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

</head>
<body>

<%@ include file="/set/header.jsp" %>

	<main class="mainDiv">
		<c:forEach var="li" items="${sclist}"> 
			
			<form action="detailCheck.do" method=post> 
			
				<input type="hidden" name="pname" value="${li.pname   }" />
				<input type="hidden" name="price" value="${li.price }" />
				
				<div class="imageDiv">
					<div><input class="img" type="image" name=submit src="${li.pimage}"  /></div>
					<div><span>${li.pname}</span></div>
					<div><fmt:formatNumber value="${li.price}" pattern="#,##0" />원</div>
				</div>
			</form>
			
		</c:forEach>
	</main>
	
	
<%@ include file="/set/footer.jsp" %>
	    
	   
</body>
</html>