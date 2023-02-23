<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN UP</title>
<script>
	function checkInfo() {
		if(document.userInfo.pw.value != document.userInfo.pw2.value) {
			alert("동일한 비밀번호를 입력해주세요.");
			return false;
		}
			
	}
</script>

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
	
		<div class="topLogo"><a href="index.jsp"><span>회원가입</span></a></div>
	
		<form class="mainForm" action="userJoin.do"  name="userInfo"> <!-- onsubmit="return checkInfo()" -->
				<div><input type="text" name="id" placeholder="아이디를 입력하세요." required></div>
				<div><input type="text" name="name" placeholder="이름을 입력하세요." required></div>
				<div><input type="password" name="pw" placeholder="비밀번호를 입력하세요." required></div>
				<div><input type="password" name="pw2" placeholder="비밀번호를 다시 입력하세요." required></div>
				<div><input type="text" name="tel" placeholder="예) 010-0000-0000"></div>
				<div class="formSubmitDiv">
					<input type="submit" value="SUBMIT">
					<input type="button" value="CANCEL" onclick="location.href='login.jsp'">
				</div>
		</form>
	</main>
</body>
</html>