package kr.co.softcampus.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.FreeCommentBean;
import kr.co.softcampus.beans.FreeLikeBean;
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
	
	public List<PhoneBookBean> getPhoneBookInfoAll(){
		return boardDao.getPhoneBookInfoAll();
	}
	
	public List<FreeBoardBean> getFreeBoardInfo(int page){
		int start = (page-1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		return boardDao.getFreeBoardInfo(rowBounds);
	}
	
	public List<InqBoardBean> getInqBoardInfo(){
		return boardDao.getInqBoardInfo();
	}
	
	public List<PhoneBookBean> readPhoneBook(String school) {
		return boardDao.readPhoneBook(school);
	}

	public FreeBoardBean getFreeBoardIdx(int free_idx) {
		return boardDao.getFreeBoardIdx(free_idx);
	}
	
	public InqBoardBean getInqBoardIdx(int inquire_idx) {
		return boardDao.getInqBoardIdx(inquire_idx);
	}
	


	public void addFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardDao.addFreeBoardInfo(tempBoardBean);
	}
	
	public void addInqBoardInfo(InqBoardBean tempBoardBean) {
		boardDao.addInqBoardInfo(tempBoardBean);
	}
	
	public void commentExist(int inquire_idx) {
		boardDao.commentExist(inquire_idx);
	}
	
	public void editFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardDao.editFreeBoardInfo(tempBoardBean);
	}
	

	public void deleteFreeBoardInfo(int free_idx) {
		boardDao.deleteFreeBoardInfo(free_idx);
	}
	
	public void deleteInqBoardInfo(int inquire_idx) {
		boardDao.deleteInqBoardInfo(inquire_idx);
	}
	
	public 	void deleteFreeComment(int free_idx, int comment_idx) {
		boardDao.deleteFreeComment(free_idx, comment_idx);
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
	
	

	public List<PhoneBookBean> searchAll(String word){
		return boardDao.searchAll(word);
	}
	
	public List<FreeBoardBean> searchFreeTitle(String free_title){
		return boardDao.searchFreeTitle(free_title);
		
	}
	
	public 	List<FreeBoardBean> searchFreeContent(String free_content){
		return boardDao.searchFreeContent(free_content);
	}
	
	public 	List<FreeBoardBean> searchFreeWriter(String free_writer){
		return boardDao.searchFreeWriter(free_writer);
	}
	
	public 	List<FreeBoardBean> searchFreeAll(String word){
		return boardDao.searchFreeAll(word);
	}

	
	public List<FreeLikeBean> getFreeLikeInfo(int free_idx, String user_id) {
		return boardDao.getFreeLikeInfo(free_idx,user_id);
	}

	
	public int addFreeLike(FreeLikeBean temp) {
		return boardDao.addFreeLike(temp);
	}

	public int editFreeLike(int likey, int free_idx, String user_id) {
		return boardDao.editFreeLike(likey, free_idx, user_id);
	}
	
	public int countFreeLike(int free_idx) {
		return boardDao.countFreeLike(free_idx);
	}

}