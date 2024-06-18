<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
</head>
<style>
	.headerDiv {
		text-align: center;
		font-size: 50px;
	}
	
	.headerA {
		width: 300px;
		height: 50px; 
		color: #828282;
		text-decoration-line: none;
	}
	
	b {
		color: aqua;
	}
	
	#logout,
	#updateInfo {
		position: absolute;		
		width: 100px;
		height: 50px;
		border: 2px solid black;
		border-radius: 2px;
		text-decoration-line: none;
		font-size: 15px;
		background: gray;
  		font-weight: bold;
		color: black;
	}
	
	#logout {
		top: 5%;
		right: 5%;
	}
	
	#updateInfo {
		top: 5%;
		right: 12%;
	}
	
	
</style>
<body>
	<div class="headerDiv">
		<c:forEach var="num" items="${boardList}" varStatus="status">
			<c:choose>
				<c:when test="${boardList.get(status.index).getId() == board.getId()}">
					<a class="headerA" href="/124003/BoardServlet/viewBoardPosts?boardId=${boardList.get(status.index).getId()}"><b>${boardList.get(status.index).getTitle()}</b></a>
				</c:when>
				<c:otherwise>
					<a class="headerA" href="/124003/BoardServlet/viewBoardPosts?boardId=${boardList.get(status.index).getId()}">${boardList.get(status.index).getTitle()}</a>
				</c:otherwise>
			</c:choose>
			<c:if test="${boardList.size()-1 != status.index}">
				|
			</c:if>
		</c:forEach>
		<div>
			<a href="/124003/BoardServlet/viewUpdateInfo" id="updateInfo">내정보 수정</a>
			<a href="/124003/BoardServlet/logout" id="logout">로그아웃</a>
		</div>
	</div>
</body>
</html>