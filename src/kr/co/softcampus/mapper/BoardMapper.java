package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softcampus.beans.PhoneBookBean;

public interface BoardMapper {
	
	@Select("select a1.list_idx, a1.list_depart, a1.list_writer_id, a2.user_name as list_writer_name, a1.list_date "
			+ "from phone_book a1, user_info a2 where a1.list_writer_id = a2.user_id"
			+ " order by list_idx desc")
	List<PhoneBookBean> getPhoneBookInfo();
	
	@Select("select a1.list_idx, a1.list_depart, a1.list_content, a1.list_writer_id, a2.user_name as list_writer_name, a1.list_date "
			+ "from phone_book a1, user_info a2 where a1.list_writer_id = a2.user_id "
			+ "and a1.list_idx = #{list_idx}")
	PhoneBookBean getPhoneBookIdx(int list_idx);
	
	@Insert("insert into phone_book (list_idx, list_depart, list_content, list_writer_id, list_date) "
			+ "values (list_seq.nextval, #{list_depart}, #{list_content}, #{list_writer_id}, #{list_date}) ")
	void addPhoneBookInfo(PhoneBookBean tempBoardBean);
	
	@Update("update phone_book set list_content = #{list_content} where list_idx = #{list_idx}")
	void editPhoneBookInfo(PhoneBookBean tempBoardBean);
	
	@Delete("delete from phone_book where list_idx = #{list_idx}")
	void deletePhoneBookInfo(int list_idx);
}
