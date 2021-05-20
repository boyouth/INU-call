package kr.co.softcampus.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.dao.BoardDao;

@Service
public class BoardService {


	@Autowired
	private BoardDao boardDao;
	
	
	public List<PhoneBookBean> getPhoneBookInfo(){
		return boardDao.getPhoneBookInfo();
	}
	
	public List<FreeBoardBean> getFreeBoardInfo(){
		return boardDao.getFreeBoardInfo();
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
	
	public InqCommentBean getInqCommentIdx(int inquire_idx) {
		return boardDao.getInqCommentIdx(inquire_idx);
	}
	
	public void addInqComment(InqCommentBean tempBoardBean) {
		boardDao.addInqComment(tempBoardBean);
	}
}
