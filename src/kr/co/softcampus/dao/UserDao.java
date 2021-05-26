package kr.co.softcampus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;

	public String checkId(String user_id) {
		return userMapper.checkId(user_id);
	}

	public void addUserInfo(UserBean joinUserInfo) {
		userMapper.addUserInfo(joinUserInfo);
	}

	public UserBean getUserInfo(UserBean tempUserInfo) {
		return userMapper.getUserInfo(tempUserInfo);
	}

	public UserBean getUserInfo_mod(String user_id) { // id를 가져오기위해 빈을 반환.
		return userMapper.getUserInfo_mod(user_id);
	}

	public void modifyUserInfo(UserBean modifyUserInfo) {
		userMapper.modifyUserInfo(modifyUserInfo);
	}

	public UserBean findUserInfo(UserBean tempUserInfo) {
		return userMapper.findUserInfo(tempUserInfo);
	}

	public void giveTempPassword(UserBean tempUserInfo) {
		userMapper.giveTempPassword(tempUserInfo);
	}

	

}
