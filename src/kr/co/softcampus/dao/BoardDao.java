package kr.co.softcampus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private BoardMapper boardMapper;
	
	
	public List<PhoneBookBean> getPhoneBookInfo(){
		return boardMapper.getPhoneBookInfo();
	}
	
	public PhoneBookBean getPhoneBookIdx(int list_idx) {
		return boardMapper.getPhoneBookIdx(list_idx);
	}
	
	public void addPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardMapper.addPhoneBookInfo(tempBoardBean);
	}
	
	public void editPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardMapper.editPhoneBookInfo(tempBoardBean);
	}

	public void deletePhoneBookInfo(int list_idx) {
		boardMapper.deletePhoneBookInfo(list_idx);
	}



}
