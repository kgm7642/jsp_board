<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="board.BoardPost"%>
<!DOCTYPE html>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<style>
	.updateDiv {
		text-align: center;
	}

	table {
		border: 1px solid black;
		margin-top: 10px;
		margin-left: auto;
		margin-right: auto;
	}
	
	input[name="subject"] {
		margin-top: 10px;
		margin-left: 10px;
		width: 500px;
		height: 40px;
	}
	
	input[name="content"] {
		margin-top: 10px;
		margin-left: 10px;
		width: 500px;
		height: 500px;
	}
	
	input[value="작성"] {
		margin: 10px;
		width: 50px;
		height: 30px;
		font-weight: bold;
	}
</style>
<body>
	<div class="updateDiv">
		<form name="mainForm" method="post" action="/124003/BoardServlet/updateBoardPost">
			<input type="hidden" name="boardId" value="${param.boardId}"/>
			<input type="hidden" name="boardPostId" value="${param.boardPostId}"/>
			<span>제목</span><input type="text" name="subject" value="${boardPost.getSubject()}">
			<br>
			<span>내용</span><input type="text" name="content" value="${boardPost.getContent()}">
			<br>		
			<input type="button" onclick="updateBoardPost();" value="작성">
		</form>
	</div>	
</body>
<script>
let mainForm = document.getElementsByName("mainForm")[0]

function updateBoardPost() {
	document.mainForm.submit();
}
</script>
</html>