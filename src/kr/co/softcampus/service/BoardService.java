package kr.co.softcampus.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.dao.BoardDao;

@Service
public class BoardService {


	@Autowired
	private BoardDao boardDao;
	
	
	public List<PhoneBookBean> getPhoneBookInfo(){
		return boardDao.getPhoneBookInfo();
	}

	public PhoneBookBean getPhoneBookIdx(int list_idx) {
		return boardDao.getPhoneBookIdx(list_idx);
	}
	
	public void addPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardDao.addPhoneBookInfo(tempBoardBean);
	}

	public void editPhoneBookInfo(PhoneBookBean tempBoardBean) {
		boardDao.editPhoneBookInfo(tempBoardBean);
	}
	
	public void deletePhoneBookInfo(int list_idx) {
		boardDao.deletePhoneBookInfo(list_idx);
	}
}
