<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style>
	body {
		padding: 60px;
	}
	
	#joinDiv {
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
		<form name="mainForm" method="post" action="/124003/BoardServlet/join">
			<div id="joinDiv">
				<table>
					<tr>
						<th></th>
						<td><span id="resultId" style="color: red;"></span></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="name"></td>
						<td><input type="button" value="중복검사" onclick="checkId();"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="fullName"></td>
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
						<td><input type="text" name="email"></td>
						<td></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" name="age"></td>
						<td></td>
					</tr>
				</table>
				
				<input type="button" value="가입하기" onclick="join();">
			</div>
		</form>
	</div>
</body>
<script>
	
let mainForm = document.getElementsByName("mainForm")[0];
let name = document.getElementsByName("name")[0];
let fullName = document.getElementsByName("fullName")[0];
let password = document.getElementsByName("password")[0];
let passwordOk = document.getElementsByName("passwordOk")[0];
let email = document.getElementsByName("email")[0];
let age = document.getElementsByName("age")[0];
let resultIdTag = document.getElementById("resultId");

function join() {
	
	if(!name.value) {
		alert("아이디를 입력하세요.");
		name.focus();
		return false;
	} else if(name.value.length < 5 || name.value.length > 12) {
		alert("아이디는 5자 이상 12자 이하로 입력해주세요.");
		name.focus();
		return false;
	} else if(resultIdTag.innerHTML == "") {
		alert("아이디 중복검사를 진행하세요.");
		name.focus();
		return false;
	} else if(resultIdTag.innerHTML != "사용 가능한 아이디") {
		alert("중복된 아이디가 있습니다.");
		name.focus();
		return false;
	}
	
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

function checkId(){
	let name = document.getElementsByName("name")[0];
	let nameTag = mainForm.name;
	if(name.value.length < 5 || name.value.length > 12){
		alert("아이디는 5자 이상 12자 이하로 입력해주세요.");
		nameTag.focus();
		return false;
	}
	if(nameTag.value.indexOf('admin') != -1){
		alert("아이디에 'admin'을 포함할 수 없습니다.");
		nameTag.focus();
	    return false;
	}
	let resultIdTag = document.getElementById("resultId");
	let xhr = new XMLHttpRequest();
	//통신할 곳과의 연결 통로 열기
	xhr.open("GET", "/124003/BoardServlet/checkName?name="+name.value, true);
	//xhr의 상태가 변할 때 호출될 함수 미리 설정
	xhr.onreadystatechange = function(){
	   if(xhr.readyState == XMLHttpRequest.DONE){
	      if(xhr.status == 200 || xhr.status == 201){
	         let txt = xhr.responseText;
	         //문자열.trim() : 문자열의 양쪽에 있는 공백 제거
	         txt = txt.trim();
	         
	         if(txt == "O"){
	            //중복체크 통과
	         	resultIdTag.innerHTML = "사용 가능한 아이디";
	         }else{
	            //중복체크 실패
	          	resultIdTag.innerHTML = "이미 존재하는 아이디";
	         }
	      } else {
	    	  console.log("ERROR");
	      }
	   }
	}
	//통신하기
	xhr.send();
}
</script>
</html>