<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div {
		text-align: center;
	}

	input[type="text"],
	input[type="password"] {
		border-radius: 4px;
		margin: 1.5px;
		width: 150px;
		height: 25px;
	}
	
 	input[type="button"] {
		margin: 3px;
		width: 160px;
		height: 25px;
	}
</style>
</head>
<body>
	<div>
		<form name="mainForm" method="post" action="/124003/BoardServlet/login">
			<div>
				<input type="text" name="name"><br>
				<input type="password" name="password">
				<br>
				<input type="button" value="로그인" onclick="login();">
			</div>
		</form>
	</div>
</body>
<script>
	
let mainForm = document.getElementsByName("mainForm")[0];
let name = document.getElementsByName("name")[0];
let password = document.getElementsByName("password")[0];

function login() {
	if(!name.value) {
		alert("아이디를 입력하세요.");
		return false;
	} else if(!password.value) {
		alert("비밀번호를 입력하세요.")
		return false;
	}
	
	document.mainForm.submit();
}
</script>
</html>