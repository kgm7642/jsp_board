<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="viewHeader.jsp"></jsp:include>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<style>
	.postDiv {
		text-align: center;
	}

	table {
		border: 1px solid black;
		margin-top: 10px;
		margin-left: auto;
		margin-right: auto;
	}
	
	input[value="삭제"] {
		margin: 10px;
	}
	
	span {
		font-weight: bold;
	}
	
	.text-align {
		text-align: left;
	}
	
	li {
		margin: 10px;
		text-align: left;
		display: flex;
	}
	
	. floatL {
		text-align: left;
	}
	
	. floatR {
		text-align: right;
	}
</style>
<body>
	<div class="postDiv">
		<form name="mainForm" method="POST" action="/124003/BoardServlet/deleteBoardPost">
			<input type="hidden" name="boardPostId" value="${boardPost.getId()}">
			<input type="hidden" name="boardId" value="${boardId}"/>
		</form>
		<main class="container">
			<header class="py-5 text-center">
			    <h1>${boardPost.getSubject()}</h1>
			</header>
			<hr>
			<div class="row g-5">
			    <section class="col-md-5 col-lg-4 order-md-last">
			        <aside>
			        	<p class="text-align"><span>게시글 번호 : </span><span class="boardPostId">${boardPost.getId()}</span></p>
			            <p class="text-align"><span>작성자 아이디 : </span><span class="nick-name">${boardPost.getCreator().getName()}</span></p>
			            <p class="text-align"><span>작성일 : </span><time>${boardPost.getCreateDate()}</time></p>
			        </aside>
			    </section>
			
			    <article class="col-md-7 col-lg-8">
			        <p>${boardPost.getContent()}<br><br></p>
			    </article>
			</div>
			<hr>
			<c:if test="${updatable}">
				<input type="button" value="수정" onclick="updateBoardPost();">
			</c:if>
			<c:if test="${deletable}">
				<input type="button" value="삭제" onclick="deleteBoardPost();">
			</c:if>

	        <div class="row g-5">
	            <section>
	                <form class="row g-3"  name="commentForm" method="POST" action="/124003/BoardServlet/createComment">
	                	<input type="hidden" name="boardPostId" value="${boardPost.getId()}"/>
						<input type="hidden" name="boardId" value="${board.getId()}"/>
	                    <div class="col-8">
	                        <input type="text" class="form-control" id="comment-textbox" placeholder="댓글 쓰기.." rows="3" name="comment"/>
	                    </div>
	                    <div class="col-auto">
	                        <input type="button" class="btn btn-primary" id="comment-submit" onclick="create();" value="쓰기"/>
	                    </div>
	                </form>
                	<form class="row g-3"  name="deleteForm" method="POST" action="/124003/BoardServlet/deleteComment">
		                <ul>
			                <c:forEach var="num" items="${comments}" varStatus="status">
				                <li>
				                	<div class="floatL">
			                            <time><small>${comments.get(status.index).getCreateDate()}</small></time>
			                            <strong>${comments.get(status.index).getUser().getName()}</strong>
			                            <p>${comments.get(status.index).getComment()}</p>
				                	</div>
				                	<div class="floatR">
								        <input type="hidden" name="boardPostId" value="${boardPost.getId()}"/>
										<input type="hidden" name="boardId" value="${board.getId()}"/>
										<input type="hidden" name="commentId" value="${comments.get(status.index).getId()}"/>
 				                		<c:if test="${sessionScope.user.getId() == comments.get(status.index).getUser().getId()}">				                		
				                			<input type="button" onclick="deleteComment();" value="삭제">
				                		</c:if>
				                	</div>
				                </li>
			                </c:forEach>
			            </ul>
	                </form>
	            </section>
	        </div>
		</main>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script>
	let commentForm = document.getElementsByName("commentForm")[0];
	// 댓글 작성 
	function create() {
		document.commentForm.submit();
	}
	
	let deleteForm = document.getElementsByName("deleteForm")[0];
	// 댓글 삭제
	function deleteComment() {
		document.deleteForm.submit();
	}
	
	// 게시글 삭제 뷰 이동 전 확인
	let mainForm = document.getElementsByName("mainForm")[0];
	function deleteBoardPost() {
		if(confirm("삭제하시겠습니까??")) {
			document.mainForm.submit();
		} else {
			return false;
		}
	}
	
	// 게시글 업데이트 뷰 이동
	function updateBoardPost() {
		document.location.href = "/124003/BoardServlet/viewUpdateBoardPost?boardId=${board.getId()}&boardPostId=${boardPost.getId()}";
	}
</script>
</html>