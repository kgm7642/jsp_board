<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<script>
	if(${!empty BC}) {
		alert("게시글 작성완료!");
	}

	if(${!empty BD}) {
		alert("게시글 삭제완료!");
	}
	
	if(${!empty BU}) {
		alert("게시글 수정완료!");
	}
</script>
<style>
	.postsDiv {
		text-align: center;
	}

	table {
		margin-top: 10px;
		margin-left: auto;
		margin-right: auto;
	}
	
	tr {
		cursor: pointer;
	}
	
	#createBoard {
		font-weight: bold;
		float: right;
		margin-right: 10px;
	}
	
	a {
		font-weight: bold;
		text-decoration-line: none;
		color: black;	
	}
	
	.pageNum {
		font-weight: bold;
		text-decoration-line: none;
		color: black;
	}
	
	#select {
		color: #FF82FF;
	}
</style>
<body onkeypress = "enterkey();">
	<div class="postsDiv">
		<h1>${board.getTitle()}</h1>
		<br>
		<a href="/124003/BoardServlet/viewCreateBoardPost?boardId=${board.getId()}" id="createBoard" 
			class="btn mb-1 btn-outline-dark btn-action">게시물 작성</a>
	    <form name="mainForm" method="GET">
		<table border="1" class="table table-striped">
			<tr bgcolor="green">
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성자 ID</th>
				<th>작성자 아이디</th>
				<th>작성자 이름</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="num" items="${boardPosts}" varStatus="status">
			<tr onmouseover="this.style.background='#FF9DFF'" 
				onClick="location.href='/124003/BoardServlet/viewBoardPost?boardPostId=${boardPosts.get(status.index).getId()}&boardId=${board.getId()}'" 
				onmouseout="this.style.background='white'">
				<td>${boardPosts.get(status.index).getId()}
				<td>${boardPosts.get(status.index).getSubject()}</td>
				<td>${boardPosts.get(status.index).getCreator().getId()}</td>
				<td>${boardPosts.get(status.index).getCreator().getName()}</td>
				<td>${boardPosts.get(status.index).getCreator().getFullName()}</td>
				<td>${boardPosts.get(status.index).getCreateDate()}</td>
			</tr>
			</c:forEach>
			</table>
		    <input type="text" name="subject">
	    	<input type="button" onclick="searchBoardPosts()" value="검색">
			<table>
				<!-- 페이징 처리 부분 -->
				<td colspan="4">
					<p align="center"><b><span style='font-size=9pt;'>
						<c:if test="${page.prev}">
							<a href="/124003/BoardServlet/viewBoardPosts?page=${page.startPage -1}&boardId=${board.getId()}&subject=${subject}">이전 페이지</a>
						</c:if>&nbsp;
						<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
							<c:choose>
								<c:when test="${num == page.getPageVO().getPage()}">
									<b class="pageNum" id="select">${num}</b>&nbsp;	
								</c:when>
								<c:otherwise>
									<a class="pageNum" href="/124003/BoardServlet/viewBoardPosts?page=${num}&boardId=${board.getId()}&subject=${subject}">${num}</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${page.next}">
							<a href="/124003/BoardServlet/viewBoardPosts?page=${page.endPage + 1}&boardId=${board.getId()}&subject=${subject}">다음 페이지</a>
						</c:if>
						</span></b>
					</p>
				</td>
				<!--End Paging -->
			</table>
	    </form>
    </div></body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script>
	let subject = document.getElementsByName("subject")[0]
	let mainForm = document.getElementsByName("mainForm")[0]
	
	//엔터키로 검색 처리
	function enterkey() {
		if(window.event.keyCode==13) {
			searchBoardPosts();
		}
	}
	
	function searchBoardPosts() {
		if(!subject.value) {
			alert("검색어를 입력하십시요");
			return false;
		}
		document.mainForm.submit();
	}
</script>
</html>