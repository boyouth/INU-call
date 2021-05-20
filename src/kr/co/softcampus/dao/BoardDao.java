package kr.co.softcampus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private BoardMapper boardMapper;
	
	
	public List<PhoneBookBean> getPhoneBookInfo(){
		return boardMapper.getPhoneBookInfo();
	}
	
	public List<FreeBoardBean> getFreeBoardInfo(){
		return boardMapper.getFreeBoardInfo();
	}
	
	public List<InqBoardBean> getInqBoardInfo(){
		return boardMapper.getInqBoardInfo();
	}
	
	public PhoneBookBean getPhoneBookIdx(int list_idx) {
		return boardMapper.getPhoneBookIdx(list_idx);
	}
	
	public FreeBoardBean getFreeBoardIdx(int free_idx) {
		return boardMapper.getFreeBoardIdx(free_idx);
	}
	
	public InqBoardBean getInqBoardIdx(int inquire_idx) {
		return boardMapper.getInqBoardIdx(inquire_idx);
	}

	
	public void addPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardMapper.addPhoneBookInfo(tempBoardBean);
	}
	
	public void addFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardMapper.addFreeBoardInfo(tempBoardBean);
	}
	
	public void addInqBoardInfo(InqBoardBean tempBoardBean) {
		boardMapper.addInqBoardInfo(tempBoardBean);
	}
	
	public void editPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardMapper.editPhoneBookInfo(tempBoardBean);
	}
	
	public void editFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardMapper.editFreeBoardInfo(tempBoardBean);
	}

	public void deletePhoneBookInfo(int list_idx) {
		boardMapper.deletePhoneBookInfo(list_idx);
	}
	
	public void deleteFreeBoardInfo(int free_idx) {
		boardMapper.deleteFreeBoardInfo(free_idx);
	}
	
	public void deleteInqBoardInfo(int inquire_idx) {
		boardMapper.deleteInqBoardInfo(inquire_idx);
	}
	
	
	public InqCommentBean getInqCommentIdx(int inquire_idx) {
		return boardMapper.getInqCommentIdx(inquire_idx);
	}

	public void addInqComment(InqCommentBean tempBoardBean) {
		boardMapper.addInqComment(tempBoardBean);
	}




}
