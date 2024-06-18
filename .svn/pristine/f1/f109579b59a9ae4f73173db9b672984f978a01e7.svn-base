package board;

public class PageVO {
	// 현재 볼 페이지 숫자
	private int page;
	// 한 페이지에서 보여질 게시글 수
	private int amount;
	
	// 1페이지는 0번부터 10번 게시물까지 보기 때문에 기본 생성자를 아래와 같이 세팅
	public PageVO() {
		this(0,10);
	}

	public PageVO(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	// 사실 상 호출하는 메서드는 getPage()가 아니라 이것이다.
	public int getSkip() {
		return (page-1)*10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
