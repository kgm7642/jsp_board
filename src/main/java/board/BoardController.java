package board;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController {
	
	private UserService userService;
	private BoardService boardService;
	
	public BoardController() {
		super();

		InputStream is =  ServiceManager.class.getResourceAsStream("/board.properties");
		Properties props = new Properties();

		try {
    		// InputStream을 사용해 파일내용 로드
    		props.load(is);
    		// properties 에서 각각의 클래스명을 가져온다.
    		String userServiceName = props.getProperty("service.userService");
    		String boardServiceName = props.getProperty("service.boardService");
    		// 가져온 클래스명을 사용해 인스턴스를 생성한다.
    		this.userService = (UserService) Class.forName(userServiceName).getDeclaredConstructor().newInstance();
    		this.boardService = (BoardService) Class.forName(boardServiceName).getDeclaredConstructor().newInstance();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	// 회원가입 View 이동
	public String viewJoin(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/board/viewJoin.jsp";
	}
	
	// 아이디 중복 확인
	public void checkName(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter out = res.getWriter();
			if(userService.checkName(req.getParameter("name"))) {
				out.write("X");
			} else {
				out.write("O");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 Action
	public String join(HttpServletRequest req, HttpServletResponse res) {
		try {
			String password = SHA256.encodeSha256(req.getParameter("password"));
			User user = new User(req.getParameter("name"), req.getParameter("fullName"), password, req.getParameter("email"), Integer.parseInt(req.getParameter("age")));
			userService.join(user);
			res.sendRedirect("/124003/BoardServlet/viewLogin");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 로그인 View 이동
	public String viewLogin(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/board/viewLogin.jsp";
	}
	
	// 로그인 Action
	public String login(HttpServletRequest req, HttpServletResponse res) {
		String password = SHA256.encodeSha256(req.getParameter("password"));
		User user = new User(req.getParameter("name"), password);
		userService.getUser(user);
		try {
			if(userService.getUser(user)==null) {
				// 로그인 실패
				res.sendRedirect("/124003/BoardServlet/viewLogin?loginFail=ok");
			} else {
				// 로그인 성공
				req.getSession().setAttribute("user", user);
				res.sendRedirect("/124003/BoardServlet/viewBoardPosts");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 내정보 수정 view 이동
	public String viewUpdateInfo(HttpServletRequest req, HttpServletResponse res) {
		viewHeader(req, res);
		return "/WEB-INF/board/viewUpdateInfo.jsp";
	}
	
	// 내정보 수정
	public String updateInfo(HttpServletRequest req, HttpServletResponse res) {
		try {			
			String password = SHA256.encodeSha256(req.getParameter("password"));
			User user = new User(req.getParameter("name"), req.getParameter("fullName"), password, req.getParameter("email"), Integer.parseInt(req.getParameter("age")));
			userService.updateInfo(user);
			req.getSession().setAttribute("user", user);
			res.sendRedirect("/124003/BoardServlet/viewBoardPosts");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 로그아웃 Action
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().invalidate();
		try {
			System.out.println("로그아웃 성공");
			res.sendRedirect("/124003/BoardServlet/viewLogin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 작성하기 View 이동
	public String viewCreateBoardPost(HttpServletRequest req, HttpServletResponse res) {
		viewHeader(req, res);
		return "/WEB-INF/board/viewCreateBoardPost.jsp";
	}
	
	// 게시글 생성하기 Action
	public String createBoardPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println("req.getAttribute(\"board\") : " + req.getAttribute("board"));
			Board board = (Board)req.getAttribute("board");
			User user = (User)req.getSession().getAttribute("user");
			boardService.createBoardPost(new BoardPost(board, req.getParameter("subject"), req.getParameter("content"), user));
			res.sendRedirect("/124003/BoardServlet/viewBoardPosts?boardId="+board.getId()+"&BC=ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 상세보기 Action
	public String viewBoardPost(HttpServletRequest req, HttpServletResponse res) {
		viewHeader(req, res);
		getComment(req, res);
		String boardId = (String) req.getParameter("boardId");
		String boardPostId = (String) req.getParameter("boardPostId");
		BoardPost boardPost = boardService.getViewBoardPost(Long.parseLong(boardPostId));
		Board board = (Board) boardService.getBoard(Long.parseLong(boardId));
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute("boardPost", boardPost);
		req.setAttribute("board", board);
		req.setAttribute("deletable", (boardService.isAdmin(board, user) || user.getId() == boardPost.getCreator().getId()));
		req.setAttribute("updatable", user.getId() == boardPost.getCreator().getId());
		return "/WEB-INF/board/viewBoardPost.jsp";
	}

	// 게시글 목록보기 Action V2
	public String viewBoardPosts(HttpServletRequest req, HttpServletResponse res) {
		viewHeader(req, res);
		Board board = (Board) req.getAttribute("board");
		if(req.getParameter("boardId")!=null) {
			String boardId = (String) req.getParameter("boardId");
			board.setId(Long.parseLong(boardId));
		}
		
		String subject = req.getParameter("subject");
		List<BoardPost> boardPosts = new ArrayList<BoardPost>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("subject", subject);
		int pageNum = 1;
		int pageAmount = 10;
		
		if(req.getParameter("page") != null && Integer.parseInt(req.getParameter("page")) > 0) {
			 pageNum = Integer.parseInt(req.getParameter("page"));
		} 
		if(req.getParameter("amount") != null && Integer.parseInt(req.getParameter("amount")) > 0) {
			pageAmount = Integer.parseInt(req.getParameter("amount"));
		}
		PageVO page = new PageVO(pageNum, pageAmount);
		
		int total;
		// total : 게시판 유형에 맞는 전체 게시물의 개수를 조회한다.
		// boardPosts : 현재 보여질 게시글 리스트를 가져온다.
		if(subject==null||subject=="") {
			// 검색어x
			total = boardService.getTotalCount(board.getId());
			boardPosts = boardService.getViewBoardPostsV2(board, page);
		} else {	
			// 검색어o
			total = boardService.getTotalCountWithKey(board.getId(), subject);
			boardPosts = boardService.getViewBoardPostsWithKeyV2(board, page, conditionMap);
		}
		
		if(req.getParameter("BC")!=null) {
			req.setAttribute("BC", "ok");
		} else if(req.getParameter("BD")!=null) {
			req.setAttribute("BD", "ok");
		} else if(req.getParameter("BU")!=null) {
			req.setAttribute("BU", "ok");
		}
		req.setAttribute("boardPosts", boardPosts);
		req.setAttribute("board", board);
		req.setAttribute("page", new Paging(page, total));
		req.setAttribute("subject", conditionMap.get("subject"));
		return "/WEB-INF/board/viewBoardPosts.jsp";
	}
		
	// 게시판 정보 조회
	public Board getBoard(HttpServletRequest req, HttpServletResponse res) {
		if(req.getParameter("boardId") != null) {
			return boardService.getBoard(Long.parseLong(req.getParameter("boardId")));
		} else if(req.getParameter("boardName") != null) {
			return boardService.getBoardByName(req.getParameter("boardName"));
		} else {
			return boardService.getBoard(2);
		}
	}
	
	// 헤더
	public String viewHeader(HttpServletRequest req, HttpServletResponse res) {
		Board board = (Board) req.getAttribute("board");
		req.setAttribute("boardList", boardService.getAllBoards());
		req.setAttribute("board", board);
		return null;
	}
	
	// 게시글 삭제
	public String deleteBoardPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			String boardPostId = (String) req.getParameter("boardPostId");
			BoardPost boardPost = (BoardPost) boardService.getViewBoardPost(Long.parseLong(boardPostId));
			Board board = boardPost.getBoard();
			User user = (User)req.getSession().getAttribute("user");
			
			boardService.deleteBoardPost(board, Long.parseLong(boardPostId), user);
			res.sendRedirect("/124003/BoardServlet/viewBoardPosts?boardId="+board.getId()+"&BD=ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 수정 view 이동
	public String viewUpdateBoardPost(HttpServletRequest req, HttpServletResponse res) {
		String boardPostId = (String) req.getParameter("boardPostId");
		BoardPost boardPost = (BoardPost) boardService.getViewBoardPost(Long.parseLong(boardPostId));
		viewHeader(req, res);
		req.setAttribute("boardPost", boardPost);
		return "/WEB-INF/board/viewUpdateBoardPost.jsp";
	}
	
	// 게시글 수정
	public String updateBoardPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			String boardPostId = (String) req.getParameter("boardPostId");
			String subject = (String) req.getParameter("subject");
			String content = (String) req.getParameter("content");
			BoardPost boardPost = (BoardPost) boardService.getViewBoardPost(Long.parseLong(boardPostId));
			User user = (User)req.getSession().getAttribute("user");
			boardPost.setCreator(user);
			boardPost.setId(Long.parseLong(boardPostId));
			boardPost.setSubject(subject);
			boardPost.setContent(content);

			boardService.updateBoardPost(boardPost, user);
			res.sendRedirect("/124003/BoardServlet/viewBoardPosts?boardId="+boardPost.getBoard().getId()+"&BU=ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 댓글 가져오기
	public String getComment(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("댓글 가져오기 컨트롤러");
		String boardPostId = (String) req.getParameter("boardPostId");
		System.out.println("req.getParameter(\"boardPostId\") : " + req.getParameter("boardPostId"));
		List<BoardComment> comments = boardService.getComment(Long.parseLong(boardPostId));
		req.setAttribute("comments", comments);
		return null;
	}
	
	// 댓글 등록
	public String createComment(HttpServletRequest req, HttpServletResponse res) {
		String boardId = (String) req.getParameter("boardId");
		String boardPostId = (String) req.getParameter("boardPostId");
		String comment = (String) req.getParameter("comment");
		BoardComment boardComment = new BoardComment();
		User user = (User) req.getSession().getAttribute("user");
		boardComment.setBoardId(Long.parseLong(boardPostId));
		boardComment.setUser(user);
		boardComment.setComment(comment);
		boardService.createComment(boardComment);
		try {
			res.sendRedirect("/124003/BoardServlet/viewBoardPost?boardPostId="+boardPostId+"&boardId="+boardId+"&CC=ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 댓글 삭제
	public String deleteComment(HttpServletRequest req, HttpServletResponse res) {
		try {
			String boardId = (String) req.getParameter("boardId");
			String boardPostId = (String) req.getParameter("boardPostId");
			String commentId = (String) req.getParameter("commentId");
			boardService.deleteBoardComment(Long.parseLong(commentId));
			res.sendRedirect("/124003/BoardServlet/viewBoardPost?boardPostId="+boardPostId+"&boardId="+boardId+"&CD=ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}