<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 등록</title>
</head>
<body>
	<a href="/124003/BoardServlet/viewBoardPosts">게시물 목록</a>

	<form name="mainForm" method="post" action="/124003/BoardServlet/createBoardPost">
		<input type="hidden" name="boardId" value="2"/>
		<span>제목</span><input type="text" name="subject">
		<br>
		<span>내용</span><input type="text" name="content">
		<br>		
		<input type="button" onclick="createBoardPost();">
	</form>
	
</body>
<script>
	
	let subject = document.getElementsByName("subject")[0]
	let content = document.getElementsByName("content")[0]
	let mainForm = document.getElementsByName("mainForm")[0]

	function createBoardPost() {
		if(!subject.value) {
			alert("제목을 입력하세요.");
			return false;
		} else if(!content.value) {
			alert("내용을 입력하세요.")
			return false;
		}
		document.mainForm.submit();
	}
</script>
</html>