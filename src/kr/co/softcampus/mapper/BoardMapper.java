package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PhoneBookBean;

public interface BoardMapper {
	
	@Select("select a1.list_idx, a1.list_depart, a1.list_writer_id, a2.user_name as list_writer_name, a1.list_date "
			+ "from phone_book a1, user_info a2 where a1.list_writer_id = a2.user_id"
			+ " order by list_idx desc")
	List<PhoneBookBean> getPhoneBookInfo();
	
	@Select("select a1.free_idx, a1.free_title, a1.free_writer_id, a2.user_name as free_writer_name, a1.free_date "
			+ "from free_board a1, user_info a2 where a1.free_writer_id = a2.user_id"
			+ " order by free_idx desc")
	List<FreeBoardBean> getFreeBoardInfo();
	
	@Select("select a1.inquire_idx, a1.inquire_type, a1.inquire_title, a1.inquire_writer_id, a2.user_name as inquire_writer_name, a1.inquire_date "
			+ "from inquire_board a1, user_info a2 where a1.inquire_writer_id = a2.user_id"
			+ " order by inquire_idx desc")
	List<InqBoardBean> getInqBoardInfo();
	
	@Select("select a1.list_idx, a1.list_depart, a1.list_content, a1.list_writer_id, a2.user_name as list_writer_name, a1.list_date "
			+ "from phone_book a1, user_info a2 where a1.list_writer_id = a2.user_id "
			+ "and a1.list_idx = #{list_idx}")
	PhoneBookBean getPhoneBookIdx(int list_idx);
	
	@Select("select a1.free_idx, a1.free_title, a1.free_content, a1.free_writer_id, a2.user_name as free_writer_name, a1.free_date "
			+ "from free_board a1, user_info a2 where a1.free_writer_id = a2.user_id "
			+ "and a1.free_idx = #{free_idx}")
	FreeBoardBean getFreeBoardIdx(int free_idx);
	
	@Select("select a1.inquire_idx, a1.inquire_type, a1.inquire_title, a1.inquire_content, a1.inquire_writer_id, a2.user_name as inquire_writer_name, a1.inquire_date "
			+ "from inquire_board a1, user_info a2 where a1.inquire_writer_id = a2.user_id and a1.inquire_idx = #{inquire_idx}")
	InqBoardBean getInqBoardIdx(int inquire_idx);
	
	@Insert("insert into phone_book (list_idx, list_depart, list_content, list_writer_id, list_date) "
			+ "values (list_seq.nextval, #{list_depart}, #{list_content}, #{list_writer_id}, #{list_date}) ")
	void addPhoneBookInfo(PhoneBookBean tempBoardBean);
	
	@Insert("insert into free_board (free_idx, free_title, free_content, free_writer_id, free_date) "
			+ "values (free_seq.nextval, #{free_title}, #{free_content}, #{free_writer_id}, #{free_date}) ")
	void addFreeBoardInfo(FreeBoardBean tempBoardBean);
	
	@Insert("insert into inquire_board (inquire_idx, inquire_type, inquire_title, inquire_content, inquire_writer_id, inquire_date) "
			+ "values (inq_seq.nextval, #{inquire_type}, #{inquire_title}, #{inquire_content}, #{inquire_writer_id}, #{inquire_date}) ")
	void addInqBoardInfo(InqBoardBean tempBoardBean);
	
	@Update("update phone_book set list_content = #{list_content} where list_idx = #{list_idx}")
	void editPhoneBookInfo(PhoneBookBean tempBoardBean);
	
	@Update("update free_board set free_content = #{free_content} where free_idx = #{free_idx}")
	void editFreeBoardInfo(FreeBoardBean tempBoardBean);
	
	@Delete("delete from phone_book where list_idx = #{list_idx}")
	void deletePhoneBookInfo(int list_idx);
	
	@Delete("delete from free_board where free_idx = #{free_idx}")
	void deleteFreeBoardInfo(int free_idx);
	
	@Delete("delete from inquire_board where inquire_idx = #{inquire_idx}")
	void deleteInqBoardInfo(int inquire_idx);
	
	
	//comment
	
	@Select("select inquire_idx, inquire_comment, comment_writer, comment_date from inquire_comment where inquire_idx = #{inquire_idx}")
	InqCommentBean getInqCommentIdx(int inquire_idx);
	
	@Insert("insert into inquire_comment (inquire_idx, inquire_comment, comment_writer, comment_date) "
			+ "values (#{inquire_idx}, #{inquire_comment}, ${comment_writer}, #{comment_date}) ")
	void addInqComment(InqCommentBean tempBoardBean);
}
