package board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	BoardPost getViewBoardPost(Long id);
	
	// 게시글 목록조회 V1
	List<BoardPost> getViewBoardPosts();
	// 게시글 목록조회(검색o) V1
	List<BoardPost> getViewBoardPostsWithKey(String subject);
	
	// 게시글 목록조회 V2
	List<BoardPost> getViewBoardPostsV2(Board board);
	//	게시글 목록조회(검색o) V2
	List<BoardPost> getViewBoardPostsWithKeyV2(Board board,  Map<String, Object> condition);
	
	// 게시글 생성하기 v1
//	BoardPost createBoardPost(BoardPost boardPost);
	
	// 게시글 생성하기 V2
	BoardPost createBoardPost(BoardPost boardPost);

	// id에 맞는 게시판 정보 조회
	Board getBoard(long id);
	
	// name에 맞는 게시판 정보 조회
	Board getBoardByName(String name);
	
	// 모든 게시판 정보 조회
	List<Board> getAllBoards();
}
