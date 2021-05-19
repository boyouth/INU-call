package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softcampus.beans.UserBean;

public interface UserMapper {

	@Select("select user_name from user_info where user_id = #{user_id} ")
	String checkId(String user_id);

	@Insert("insert into user_info (user_id, user_name, user_pw, email, phone) values (#{user_id}, #{user_name}, #{user_pw}, #{email}, #{phone}) ")
	void addUserInfo(UserBean joinUserInfo);
	
	@Select("select user_id, user_name, email, substr(phone,4) as phone from user_info where user_id = #{user_id} and user_pw = #{user_pw} ")
	UserBean getUserInfo(UserBean tempUserInfo);

	@Select("select user_id, user_name, email, phone from user_info where user_id = #{user_id}")
	UserBean getUserInfo_mod(String user_id); // 현재 로그인한 사용자의 아이디를 가져옴.
	

	@Update("update user_info set user_pw=#{user_pw}, email=#{email} , phone=#{phone} where user_id = #{user_id} ")
	void modifyUserInfo(UserBean modifyUserInfo);
	
	@Select("select user_id, user_name from user_info where user_name = #{user_name} and email = #{email}")
	UserBean findUserInfo(UserBean tempUserInfo);
}
