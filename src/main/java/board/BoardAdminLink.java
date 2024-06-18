package board;

import java.sql.Timestamp;

public class BoardAdminLink {
	
	// 테이블 아이디
	private long id;
	// 연관된 게시판
	private Board board;
	// 관리자 아이디
	private User admin;
	// 관리자로 설정된 시간
	private Timestamp createDate;
	
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
	public User getAdmin() {
		if (this.admin == null) {
			this.admin = new User();
		}
		return this.admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
