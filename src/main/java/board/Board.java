package board;

import java.sql.Timestamp;

public class Board {
	
	// 테이블 아이디
	private long id;
	// 게시판 이름(ex: notice)
	private String name;
	// 게시판 이름을 한글로 표시(ex: 공지사항)
	private String title;
	// 댓글 작성 가능 여부
	private boolean commentEnabled;
	// 게시글 작성 시간
	private Timestamp createDate;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCommentEnabled() {
		return commentEnabled;
	}
	public void setCommentEnabled(boolean commentEnabled) {
		this.commentEnabled = commentEnabled;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
