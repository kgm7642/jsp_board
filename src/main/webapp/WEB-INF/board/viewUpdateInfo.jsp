<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
</head>
<style>
	body {
		padding: 60px;
	}
	
	#updateInfoDiv {
		text-align: center;
	}
	
	table {
		margin-top: 10px;
		margin-left: auto;
		margin-right: auto;
	}
	
	th, td {
		padding: 12px;
	}

	input[type="text"],
	input[type="password"] {
		width: 500px;
		height: 30px;
	}
	
	input {
		font-weight: bold;
	}
	
	input[value="가입하기"] {
		width: 100px;
		height: 30px;
		font-weight: bold;
	}
</style>
<body>
	<div>
		<form name="mainForm" method="post" action="/124003/BoardServlet/updateInfo">
			<div id="updateInfoDiv">
				<table>
					<tr>
						<th>이름</th>
						<td><input type="text" value="${sessionScope.user.getFullName()}" name="fullName"></td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password" placeholder="대문자, 소문자, 숫자, 특수문자 모두 포함"></td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" name="passwordOk" placeholder="비밀번호를 다시 한번 입력해주세요"></td>
						<td></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" value="${sessionScope.user.getEmail()}" name="email"></td>
						<td></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" value="${sessionScope.user.getAge()}" name="age"></td>
						<td></td>
					</tr>
				</table>
				<input type="hidden" value="${sessionScope.user.getName()}" name="name">
				<input type="button" value="수정완료" onclick="updateInfo();">
			</div>
		</form>
	</div>
</body>
<script>
let mainForm = document.getElementsByName("mainForm")[0];
let fullName = document.getElementsByName("fullName")[0];
let password = document.getElementsByName("password")[0];
let passwordOk = document.getElementsByName("passwordOk")[0];
let email = document.getElementsByName("email")[0];
let age = document.getElementsByName("age")[0];

function updateInfo() {
	if(!fullName.value) { 
		alert("이름을 입력하세요.");
		fullName.focus();
		return false;
	}
	
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_-]).{8,}$/
	if(!password.value) {
		alert("비밀번호를 입력하세요.");
		password.focus();
		return false;
	} else if(!reg.test(password.value)) {
		alert("비밀번호는 8자 이상, 숫자, 대문자, 소문자, 특수문자를 모두 포함해야 합니다.");
		password.focus();
		return false;
	} else if(!passwordOk.value) {
		alert("비밀번호 확인을 입력하세요.");
		passwordOk.focus();
		return false;
	} else if(passwordOk.value != password.value) {
		alert("비밀번호가 다릅니다. 확인해주세요.");
		return false;
	}
	
	var emailC = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if(!email.value) {
		alert("이메일을 입력하세요.");
		email.focus();
		return false;
	} else if(!emailC.test(email.value)) { 
		alert("이메일 형식이 잘못되었습니다.");
		email.focus();
		return false;
	}
	
	if(!age.value) {
		alert("나이를 입력하세요.");
		age.focus();
		return false;
	}
	document.mainForm.submit();
}
</script>
</html>