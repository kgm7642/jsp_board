package board;

public class Paging {
	// 시작 레코드 번호와 마지막 레코드 번호
	private int startPage, endPage;
	// 이전, 다음 버튼의 유무 확인
	private boolean prev, next;
	// 게시글 전체 개수
	private int total;
	// 현재 페이지 레코드 번호와 보여질 레코드 수를 가지고 있는 객체
	private PageVO pageVO;
	
	public Paging(PageVO vo, int total) {
		this.pageVO = vo;
		this.total = total;
		
		// 마지막 레코드 번호를 구하는 식
		this.endPage = (int)(Math.ceil(pageVO.getPage() / 10.0)) * 10;
		// 시작 레코드 번호를 구하는 식
		this.startPage = this.endPage - 9;
		
		// 실제 마지막 레코드 번호를 구하는 식
		int realEnd = (int)(Math.ceil((total * 1.0)/pageVO.getAmount()));
	
		// 실제 마지막 레코드가 더 작다면 마지막 레코드를 실제 마지막 레코드 값으로 대체
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 시작 레코드 번호가 1보다 클 경우에만 이전버틑 활성화
		this.prev = this.startPage > 1;
		// 마지막 레코드 번호가 실제 마지막 레코드 번호보다 작을 경우에만 다음버튼 활성화
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public PageVO getPageVO() {
		return pageVO;
	}
	
	
}
