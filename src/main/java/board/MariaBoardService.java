package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MariaBoardService extends ServiceManager implements BoardService {
	
	// 게시글 상세보기 로직
	public BoardPost getViewBoardPost(Long id) {
		BoardPost boardPost = new BoardPost();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select a.id, a.boardId, a.subject, a.content, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.createDate from boardpost a LEFT OUTER JOIN USER b ON a.creatorId = b.id WHERE a.id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				User user = new User();
				boardPost.setId(rs.getLong("id"));
				boardPost.setId(rs.getLong("boardId"));
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.setCreator(user);
				boardPost.getCreator().setId(rs.getLong("creatorId"));
				boardPost.getCreator().setName(rs.getString("creatorName"));
				boardPost.getCreator().setFullName(rs.getString("creatorFullName"));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardPost;
	}
	
	// 게시글 목록보기 로직(검색 키워드x)
	public List<BoardPost> getViewBoardPosts() {
		List<BoardPost> boardPosts = new ArrayList<BoardPost>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select a.id, a.subject, a.content, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.createDate from boardpost a LEFT OUTER JOIN USER b ON a.creatorId = b.id ORDER BY a.id DESC");
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				User user = new User();
				BoardPost boardPost = new BoardPost();
				boardPost.setId(rs.getLong("id"));
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.setCreator(user);
				boardPost.getCreator().setId(rs.getLong("creatorId"));
				boardPost.getCreator().setName(rs.getString("creatorName"));
				boardPost.getCreator().setFullName(rs.getString("creatorFullName"));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
				boardPosts.add(boardPost);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardPosts;
	}
	
	// 게시글 목록보기 로직(검색 키워드o)
	public List<BoardPost> getViewBoardPostsWithKey(String subject) {
		List<BoardPost> boardPosts = new ArrayList<BoardPost>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select a.id, a.subject, a.content, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.createDate from boardpost a LEFT OUTER JOIN USER b ON a.creatorId = b.id WHERE subject LIKE '%" + subject + "%' ORDER BY a.id DESC");
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				User user = new User();
				BoardPost boardPost = new BoardPost();
				boardPost.setId(rs.getLong("id"));
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.setCreator(user);
				boardPost.getCreator().setId(rs.getLong("creatorId"));
				boardPost.getCreator().setName(rs.getString("creatorName"));
				boardPost.getCreator().setFullName(rs.getString("creatorFullName"));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
				boardPosts.add(boardPost);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardPosts;
	}
	
	
	// 게시글 목록보기 로직(검색 키워드x) V2
	public List<BoardPost> getViewBoardPostsV2(Board board) {
		System.out.println("게시글 목록보기 로직 서비스");
		System.out.println("board.getId() : " + board.getId());
		List<BoardPost> boardPosts = new ArrayList<BoardPost>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select a.id, a.subject, a.content, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.createDate from boardpost a LEFT OUTER JOIN USER b ON a.creatorId = b.id WHERE a.boardId = " + board.getId() + " ORDER BY a.id DESC");
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				User user = new User();
				BoardPost boardPost = new BoardPost();
				boardPost.setId(rs.getLong("id"));
				boardPost.setBoard(board);
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.setCreator(user);
				boardPost.getCreator().setId(rs.getLong("creatorId"));
				boardPost.getCreator().setName(rs.getString("creatorName"));
				boardPost.getCreator().setFullName(rs.getString("creatorFullName"));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
				boardPosts.add(boardPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardPosts;
	}
	
	// 게시글 목록보기 로직(검색 키워드o) V2
	public List<BoardPost> getViewBoardPostsWithKeyV2(Board board, Map<String, Object> condition) {
		List<BoardPost> boardPosts = new ArrayList<BoardPost>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select a.id, a.subject, a.content, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.createDate from boardpost a LEFT OUTER JOIN USER b ON a.creatorId = b.id WHERE a.boardId = " + board.getId() + " AND subject LIKE '%" + condition.get("subject") + "%' ORDER BY a.id DESC");
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				User user = new User();
				BoardPost boardPost = new BoardPost();
				boardPost.setId(rs.getLong("id"));
				boardPost.setBoard(board);
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.setCreator(user);
				boardPost.getCreator().setId(rs.getLong("creatorId"));
				boardPost.getCreator().setName(rs.getString("creatorName"));
				boardPost.getCreator().setFullName(rs.getString("creatorFullName"));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
				boardPosts.add(boardPost);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardPosts;
	}

	// 게시글 생성하기 로직 V1
//	public BoardPost createBoardPost(BoardPost boardPost) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//
//		try {
//			conn = getConnection();
//			String query = "INSERT INTO BOARDPOST (subject, content, creatorId, createDate) VALUES (?, ?, ?, NOW())";
//			stmt = conn.prepareStatement(query);
//			stmt.setString(1, boardPost.getSubject());
//			stmt.setString(2, boardPost.getContent());
//			stmt.setLong(3, boardPost.getCreator().getId());
//			stmt.executeUpdate();
//
//			stmt = conn.prepareStatement("select * from boardPost where id = LAST_INSERT_ID()");
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()){
//				boardPost.setId(rs.getLong("id"));
//				boardPost.setSubject(rs.getString("subject"));
//				boardPost.setContent(rs.getString("content"));
//				boardPost.getCreator().setId((rs.getLong("creatorId")));
//				boardPost.setCreateDate(rs.getTimestamp("createDate"));
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}	
//		
//		return boardPost;
//	}
	
	// 게시글 생성하기 로직 V2
	public BoardPost createBoardPost(BoardPost boardPost) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Board board = boardPost.getBoard();
		
		try {
			conn = getConnection();
			String query = "INSERT INTO BOARDPOST (boardId, subject, content, creatorId, createDate) VALUES (?, ?, ?, ?, NOW())";
			stmt = conn.prepareStatement(query);
			stmt.setLong(1, board.getId());
			stmt.setString(2, boardPost.getSubject());
			stmt.setString(3, boardPost.getContent());
			stmt.setLong(4, boardPost.getCreator().getId());
			stmt.executeUpdate();

			stmt = conn.prepareStatement("select * from boardPost where id = LAST_INSERT_ID()");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				boardPost.setId(rs.getLong("id"));
				boardPost.getBoard().setId(rs.getLong("boardId"));
				boardPost.setSubject(rs.getString("subject"));
				boardPost.setContent(rs.getString("content"));
				boardPost.getCreator().setId((rs.getLong("creatorId")));
				boardPost.setCreateDate(rs.getTimestamp("createDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardPost;
	}
	
	// 게시판 id에 해당하는 게시판 정보 모두 조회
	public Board getBoard(long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Board board = new Board();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from board where id = ?");
			stmt.setLong(1, id);
			
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				board.setId(rs.getLong("id"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setCommentEnabled(rs.getBoolean("commentEnabled"));
				board.setCreateDate(rs.getTimestamp("createDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	// 게시판 name에 해당하는 게시판 정보 모두 조회
	public Board getBoardByName(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Board board = new Board();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from board where name = ?");
			stmt.setString(1, name);

			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				board.setId(rs.getLong("id"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setCommentEnabled(rs.getBoolean("commentEnabled"));
				board.setCreateDate(rs.getTimestamp("createDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	// 모든 게시판 정보 조회
	public List<Board> getAllBoards() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Board> boards = new ArrayList<Board>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from board");
			// 쿼리 실행
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setId(rs.getLong("id"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setCommentEnabled(rs.getBoolean("commentEnabled"));
				board.setCreateDate(rs.getTimestamp("createDate"));
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}
}
