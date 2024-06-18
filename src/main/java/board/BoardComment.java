package board;

import java.sql.Timestamp;

public class BoardComment {

	// 테이블 아이디
	private long id;
	// 댓글 내용
	private String comment;
	// 댓글을 작성한 유저	
	private User user;
	// 댓글이 있는 게시글 번호
	private long boardId;
	// 댓글 작성 시간
	private Timestamp createDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
