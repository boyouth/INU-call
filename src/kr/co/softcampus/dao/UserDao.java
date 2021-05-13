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
}
