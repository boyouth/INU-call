package kr.co.softcampus.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserInfo")
	private UserBean loginUserInfo;

	public boolean checkId(String user_id) {
		String name = userDao.checkId(user_id); // name이 return
		System.out.println(name);

		if (name == null) return false; // 정보가 없다면 false 반환.
		else return true;
	}

	public void addUserInfo(UserBean joinUserInfo) {

		userDao.addUserInfo(joinUserInfo);
	}
	
	public void getUserInfo(UserBean tempUserInfo) {
		UserBean temp = userDao.getUserInfo(tempUserInfo);
		
		if(temp != null) {
			loginUserInfo.setUser_name(temp.getUser_name());
			loginUserInfo.setLog_in(true);
		}
	}

}
