package board;

import java.sql.Timestamp;

public class Board {
	
	private long id;
	private String name;
	private String title;
	private boolean commentEnabled;
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
