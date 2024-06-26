package board;

import java.sql.Timestamp;

public class BoardPost {
	
	// 테이블 아이디
	private long id;
	// 게시글의 종류를 알 수 있는 board 객체 (ex: 공지사항, 자유게시판 등)
	private Board board;
	// 게시글 제목
	private String subject;
	// 게시글 내용
	private String content;
	// 게시글 작성자의 정보를 알 수 있는 User 객체
	private User creator;
	// 게시글 작성 시간
	private Timestamp createDate;
	
	public BoardPost() {
		super();
	}

	public BoardPost(long id, String subject, User creator, Timestamp createDate) {
		super();
		this.id = id;
		this.subject = subject;
		this.creator = creator;
		this.createDate = createDate;
	}

	public BoardPost(Board board, String subject, String content, User creator) {
		super();
		this.board = board;
		this.subject = subject;
		this.content = content;
		this.creator = creator;
	}
	
	public BoardPost(String subject, String content, User creator) {
		super();
		this.subject = subject;
		this.content = content;
		this.creator = creator;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
}
