<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<form name="mainForm" method="get" action="/lecture/servlet/MultiplicationServletV2">
		<input type="text" name="number">
		<input type="submit" onclick="viewMultiplication()" value="전송"></input>
	</form>
</body>
<script>
	let number = document.getElementsByName("number")[0]
	function viewMultiplication() {
		if(!number.value || isNaN(number.value)) {
			alert("숫자만 입력해주세요.");
			return false;
		}
	}
</script>
</html>