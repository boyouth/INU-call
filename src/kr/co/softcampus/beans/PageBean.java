package kr.co.softcampus.beans;

public class PageBean {
	
	private int min; // 최소 페이지 번호
	private int max; // 최대 페이지 번호
	private int prevPage; // 이전 버튼의 페이지 번호
	private int nextPage; // 다음 버튼의 페이지 번호
	private int pageCnt; // 전체 페이지 개수 
	private int currentPage; // 현재 페이지 번호

	//contentCnt : 전체글개수 , currentPage : 현재 페이지 , contentPageCnt : 페이지당 글의 개수 , paginationCnt : 페이지 버튼의 개수
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		//현재 페이지 번호
		this.currentPage = currentPage;
	
		
		//전체 페이지 개수
		pageCnt = contentCnt / contentPageCnt;
		// ex. 533/10 = 53...3페이지
		if(contentCnt%contentPageCnt>0) pageCnt++;
		
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		
		max = min + paginationCnt - 1;
		
		if(max > pageCnt) max = pageCnt;
		
		prevPage = min - 1;
		nextPage = max + 1;
		if(nextPage > pageCnt) nextPage = pageCnt;
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}

}
