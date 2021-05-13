package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.UserBean;

public interface UserMapper {

	@Select("select user_name from user_info where user_id = #{user_id} ")
	String checkId(String user_id);

	@Insert("insert into user_info (user_id, user_name, user_pw, email, phone) values (#{user_id}, #{user_name}, #{user_pw}, #{email}, #{phone}) ")
	void addUserInfo(UserBean joinUserInfo);
	
	@Select("select user_name from user_info where user_id = #{user_id} and user_pw = #{user_pw} ")
	UserBean getUserInfo(UserBean tempUserInfo);

}
