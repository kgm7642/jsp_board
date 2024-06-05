<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="board.BoardPost"%>
<% 
	List<BoardPost> boardPosts = new ArrayList<BoardPost>();
	boardPosts = (ArrayList<BoardPost>) request.getAttribute("boardPosts");
%>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<style>
	
</style>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>
	<div>
		<h1><% out.print(boardPosts.get(1).getBoard().getTitle()); %></h1>
		<br>
		<a href="/124003/BoardServlet/viewCreateBoardPost">게시물 작성</a>
	    <form name="mainForm" method="post">
	    <input type="text" name="subject">
	    <input type="button" onclick="searchBoardPosts()" value="검색">
		<table border="1">
			<tr bgcolor="gray">
				<th>ID</th>
				<th>제목</th>
				<th>작성자 ID</th>
				<th>작성자 아이디</th>
				<th>작성자 이름</th>
				<th>작성일</th>
			</tr>
			<%
				for(int i=0; i<boardPosts.size(); i++) {
			%>
				
			<tr>
				<td><% out.print(boardPosts.get(i).getId()); %></td>
				<td><a href="/124003/BoardServlet/viewBoardPost?id=<%=boardPosts.get(i).getId()%>"><% out.print(boardPosts.get(i).getSubject()); %></a></td>
				<td><% out.print(boardPosts.get(i).getCreator().getId()); %></td>
				<td><% out.print(boardPosts.get(i).getCreator().getName()); %></td>
				<td><% out.print(boardPosts.get(i).getCreator().getFullName()); %></td>
				<td><% out.print(boardPosts.get(i).getCreateDate()); %></td>
			</tr>	
								
			<%		
				}
			%>
	    </form>
    </div>
</body>
<script>
let subject = document.getElementsByName("subject")[0]
let mainForm = document.getElementsByName("mainForm")[0]

function searchBoardPosts() {
	if(!subject.value) {
		alert("검색어를 입력하십시요");
		return false;
	}
	document.mainForm.submit();
}
</script>
</html>