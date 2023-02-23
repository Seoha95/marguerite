<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	.mainDiv{
		display:flex;
		flex-direction: column;	
		align-items: center;
		width: 100%;
	}
	

	.topLogo{
		margin:150px 0px 100px 0px;
	}
	
	
	.topLogo > a{
		text-decoration-line: none;
		color:black;
	}
	
	.topLogo > a > span{
		
		font-size:30px;
		font-weight: 550;
		
	}
	
	.mainForm{
		display:flex;
		flex-direction: column;	
		align-items: center;
	}
	
	
	.mainForm > div > input{
	
		width: 400px;
		height: 35px;
		border : 2px solid rgba(0, 0, 0, 0.2);
	}

	.formSubmitDiv{
	
		width:400px;
		display:flex;
		align-items: center;
		justify-content: space-between;
		margin-top:20px;
		
	
	}
	

</style>

</head>
<body>
	<main class="mainDiv">
	
		<div class="topLogo"><a href="index.jsp"><span>비밀번호찾기</span></a></div>
	
		<form class="mainForm" action="findPw.do">
			<div><input type="text" name="id" placeholder="아이디를 입력하세요." required></div>
			<div><input type="text" name="tel" placeholder="전화번호를 입력하세요." required></div>
			<div class="formSubmitDiv">
				<input type="submit" value="비밀번호찾기">
				<input type="button" value="취소" onclick="location.href='login.jsp'" />	
			</div>
		</form>
	
	</main>
</body>
</html>