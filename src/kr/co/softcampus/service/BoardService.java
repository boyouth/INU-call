package kr.co.softcampus.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.FreeCommentBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PageBean;
import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.dao.BoardDao;

@Service
public class BoardService {


	@Autowired
	private BoardDao boardDao;
	
	private int page_listcnt = 10;
	private int page_pagination = 10;
	
	
	public List<PhoneBookBean> getPhoneBookInfo(){
		return boardDao.getPhoneBookInfo();
	}
	
	public List<FreeBoardBean> getFreeBoardInfo(int page){
		int start = (page-1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		return boardDao.getFreeBoardInfo(rowBounds);
	}
	
	public List<InqBoardBean> getInqBoardInfo(){
		return boardDao.getInqBoardInfo();
	}
	
	public PhoneBookBean getPhoneBookIdx(int list_idx) {
		return boardDao.getPhoneBookIdx(list_idx);
	}
	
	public FreeBoardBean getFreeBoardIdx(int free_idx) {
		return boardDao.getFreeBoardIdx(free_idx);
	}
	
	public InqBoardBean getInqBoardIdx(int inquire_idx) {
		return boardDao.getInqBoardIdx(inquire_idx);
	}
	
	
	public void addPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardDao.addPhoneBookInfo(tempBoardBean);
	}

	public void addFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardDao.addFreeBoardInfo(tempBoardBean);
	}
	
	public void addInqBoardInfo(InqBoardBean tempBoardBean) {
		boardDao.addInqBoardInfo(tempBoardBean);
	}
	
	public void editPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardDao.editPhoneBookInfo(tempBoardBean);
	}
	
	public void editFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardDao.editFreeBoardInfo(tempBoardBean);
	}
	
	public void deletePhoneBookInfo(int list_idx) {
		boardDao.deletePhoneBookInfo(list_idx);
	}
	
	public void deleteFreeBoardInfo(int free_idx) {
		boardDao.deleteFreeBoardInfo(free_idx);
	}
	
	public void deleteInqBoardInfo(int inquire_idx) {
		boardDao.deleteInqBoardInfo(inquire_idx);
	}
	
	public PageBean countFreeContent(int current) {
		int cnt = boardDao.countFreeContent();
		
		PageBean pageBean = new PageBean(cnt, current, page_listcnt, page_pagination);
		
		return pageBean;
	}
	
	//
	
	
	public InqCommentBean getInqCommentIdx(int inquire_idx) {
		return boardDao.getInqCommentIdx(inquire_idx);
	}
	
	public void addInqComment(InqCommentBean tempBoardBean) {
		boardDao.addInqComment(tempBoardBean);
	}
	
	public List<FreeCommentBean> getFreeCommentIdx(int free_idx) {
		return boardDao.getFreeCommentIdx(free_idx);
	}
	
	public void addFreeComment(FreeCommentBean tempBoardBean) {
		boardDao.addFreeComment(tempBoardBean);
	}
	
	public int countFreeComment(int free_idx) {
		return boardDao.countFreeComment(free_idx);
	}
	
	public int addFreeHit(int free_idx) {
		return boardDao.addFreeHit(free_idx);
	}
	
	public int addFreeAgree(int free_idx) {
		return boardDao.addFreeAgree(free_idx);
	}
	
	public int addPhoneHit(int list_idx) {
		return boardDao.addPhoneHit(list_idx);
	}
}
