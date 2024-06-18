package board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	// 게시글 상세보기
	BoardPost getViewBoardPost(Long id);
	
	// 게시글 목록조회 V1
	List<BoardPost> getViewBoardPosts();
	// 게시글 목록조회(검색o) V1
	List<BoardPost> getViewBoardPostsWithKey(String subject);
	
	// 게시글 목록조회 V2
	List<BoardPost> getViewBoardPostsV2(Board board, PageVO page);
	//	게시글 목록조회(검색o) V2
	List<BoardPost> getViewBoardPostsWithKeyV2(Board board, PageVO page,  Map<String, Object> condition);

	// 게시글 생성하기 V2
	BoardPost createBoardPost(BoardPost boardPost);

	// id에 맞는 게시판 정보 조회
	Board getBoard(long id);
	
	// name에 맞는 게시판 정보 조회
	Board getBoardByName(String name);
	
	// 모든 게시판 정보 조회
	List<Board> getAllBoards();
	
	// 사용자가 게시판의 관리자인지 확인
	boolean isAdmin(Board board, User user);
	
	// 게시물 삭제
	BoardPost deleteBoardPost(Board board, long id, User user);
	
	// 게시물 수정
	BoardPost updateBoardPost(BoardPost boardPost, User user);
	
	// 게시물 전체 개수
	int getTotalCount(Long boardId);
	
	// 게시물 전체 개수(검색o)
	int getTotalCountWithKey(Long boardId, String subject);
	
	// 댓글 전체 조회
	List<BoardComment> getComment(Long boardPostId);
	
	// 댓글 작성
	BoardComment createComment(BoardComment boardComment);
	
	// 댓글 삭제
	void deleteBoardComment(long id);
}
