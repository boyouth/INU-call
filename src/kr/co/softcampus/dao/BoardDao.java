package kr.co.softcampus.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.FreeCommentBean;
import kr.co.softcampus.beans.FreeLikeBean;
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
	
	public List<PhoneBookBean> getPhoneBookInfoAll(){
		return boardMapper.getPhoneBookInfoAll();
	}

	public List<FreeBoardBean> getFreeBoardInfo(RowBounds rowBounds) {
		return boardMapper.getFreeBoardInfo(rowBounds);
	}

	public List<InqBoardBean> getInqBoardInfo() {
		return boardMapper.getInqBoardInfo();
	}

	public List<PhoneBookBean> readPhoneBook(String school) {
		return boardMapper.readPhoneBook(school);
	}

	public FreeBoardBean getFreeBoardIdx(int free_idx) {
		return boardMapper.getFreeBoardIdx(free_idx);
	}

	public InqBoardBean getInqBoardIdx(int inquire_idx) {
		return boardMapper.getInqBoardIdx(inquire_idx);
	}


	public void addFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardMapper.addFreeBoardInfo(tempBoardBean);
	}

	public void addInqBoardInfo(InqBoardBean tempBoardBean) {
		boardMapper.addInqBoardInfo(tempBoardBean);
	}


	public void editFreeBoardInfo(FreeBoardBean tempBoardBean) {
		boardMapper.editFreeBoardInfo(tempBoardBean);
	}



	public void deleteFreeBoardInfo(int free_idx) {
		boardMapper.deleteFreeBoardInfo(free_idx);
	}

	public void deleteInqBoardInfo(int inquire_idx) {
		boardMapper.deleteInqBoardInfo(inquire_idx);
	}
	
	public 	void deleteFreeComment(int free_idx, int comment_idx) {
		boardMapper.deleteFreeComment(free_idx, comment_idx);
	}
	
	
	public int countFreeContent() {
		return boardMapper.countFreeContent();
	}
	//

	public InqCommentBean getInqCommentIdx(int inquire_idx) {
		return boardMapper.getInqCommentIdx(inquire_idx);
	}

	public void addInqComment(InqCommentBean tempBoardBean) {
		boardMapper.addInqComment(tempBoardBean);
	}

	public List<FreeCommentBean> getFreeCommentIdx(int free_idx) {
		return boardMapper.getFreeCommentIdx(free_idx);
	}

	public void addFreeComment(FreeCommentBean tempBoardBean) {
		boardMapper.addFreeComment(tempBoardBean);
	}

	public int countFreeComment(int free_idx) {
		return boardMapper.countFreeComment(free_idx);
	}

	public int addFreeHit(int free_idx) {
		return boardMapper.addFreeHit(free_idx);
	}
	
	
	
	public List<PhoneBookBean> searchAll(String word){
		return boardMapper.searchAll(word);
	}

	public List<FreeBoardBean> searchFreeTitle(String free_title){
		return boardMapper.searchFreeTitle(free_title);
		
	}
	
	public 	List<FreeBoardBean> searchFreeContent(String free_content){
		return boardMapper.searchFreeContent(free_content);
	}
	
	public 	List<FreeBoardBean> searchFreeAll(String word){
		return boardMapper.searchFreeAll(word);
	}

	
	
	public List<FreeLikeBean> getFreeLikeInfo(int free_idx, String user_id) {
		return boardMapper.getFreeLikeInfo(free_idx,user_id);
	}

	
	public int addFreeLike(FreeLikeBean temp) {
		return boardMapper.addFreeLike(temp);
	}

	public int editFreeLike(int likey, int free_idx, String user_id) {
		return boardMapper.editFreeLike(likey, free_idx, user_id);
	}
	
	public int countFreeLike(int free_idx) {
		return boardMapper.countFreeLike(free_idx);
	}

}
