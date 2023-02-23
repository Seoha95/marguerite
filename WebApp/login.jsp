<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

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

	.mainFormCenterInput {
	
		border-top : none;
		margin-bottom : 20px;
				
	}

	.mainFormLastInput{
		
		margin-bottom:10px;
		
	}
	
	.formDownDiv{
	
		width:400px;
		display:flex;
		align-items: center;
		justify-content: space-between;
		
	
	}
	
	
	
	
	
</style>

</head>
<body>

	<main class="mainDiv">
		<div class="topLogo"><a href="index.jsp"><span>marguerite</span></a></div>
		
		<form action="login.do" class="mainForm">
				<div><input type="text" name="id" placeholder="아이디를 입력하세요." required></div>
				<div><input class="mainFormCenterInput" type="password" name="pw" placeholder="비밀번호를 입력하세요." required></div>
				<div><input class="mainFormLastInput" type="submit" value="로그인"></div>
		</form>
		
		<div class="formDownDiv">
			<div>
				<a href="findId.jsp">아이디찾기</a>
				<a href="findPw.jsp" class="findPwAtag">비밀번호 찾기</a>
			</div>
			<div>
				<a href="join.jsp">회원가입</a>
				<a href="userDelete.jsp">회원탈퇴</a>
			</div>
		</div>
	
	</main>
</body>
</html>