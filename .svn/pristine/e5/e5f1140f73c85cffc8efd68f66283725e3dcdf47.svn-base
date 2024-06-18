<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% 
	
	List<Board> boards = new ArrayList<Board>();
	boards = (ArrayList<Board>) request.getAttribute("boardList");
	Board board = (Board) request.getAttribute("board");
%>
<html>
<head>
<meta charset="EUC-KR">
<title>헤더</title>
</head>
<body>
	<%
		for(int i=0; i<boards.size(); i++) {
	%>
			<%
				if(boards.get(i).getId() == board.getId()) {
			%>
					<a href="/124003/BoardServlet/viewBoardPosts"><b><% out.print(boards.get(i).getTitle()); %></b></a>
			<%	
				} else {
			%>
					<a href="/124003/BoardServlet/viewBoardPosts"><% out.print(boards.get(i).getTitle()); %></a>
			<%
				}
				if(i!=boards.size()-1) {
					out.print("|");
				}
			%>
	
	<%
		}
	%>
</body>
</html>