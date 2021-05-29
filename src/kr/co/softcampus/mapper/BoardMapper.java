package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.FreeCommentBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PhoneBookBean;

public interface BoardMapper {

	
	@Select("select distinct(school) from inu_info order by school asc")
	List<PhoneBookBean> getPhoneBookInfo();
	
	@Select("select school, major, phone, commentary from inu_info order by school asc")
	List<PhoneBookBean> getPhoneBookInfoAll();	
	
	@Select("select a1.free_idx, a1.free_title, a1.free_writer_id, a2.user_name as free_writer_name, a1.free_date "
			+ "from free_board a1, user_info a2 where a1.free_writer_id = a2.user_id" + " order by free_idx desc")
	List<FreeBoardBean> getFreeBoardInfo(RowBounds rowBounds);

	@Select("select a1.inquire_idx, a1.inquire_type, a1.inquire_title, a1.inquire_writer_id, a2.user_name as inquire_writer_name, a1.inquire_date "
			+ "from inquire_board a1, user_info a2 where a1.inquire_writer_id = a2.user_id"
			+ " order by inquire_idx desc")
	List<InqBoardBean> getInqBoardInfo();


	@Select("select school, major, phone, commentary from inu_info where school = #{school}")
	List<PhoneBookBean> readPhoneBook(String school);

	@Select("select a1.free_idx, a1.free_title, a1.free_content, a1.free_writer_id, a2.user_name as free_writer_name, a1.free_date, a1.free_hit "
			+ "from free_board a1, user_info a2 where a1.free_writer_id = a2.user_id "
			+ "and a1.free_idx = #{free_idx}")
	FreeBoardBean getFreeBoardIdx(int free_idx);

	@Select("select a1.inquire_idx, a1.inquire_type, a1.inquire_title, a1.inquire_content, a1.inquire_writer_id, a2.user_name as inquire_writer_name, a1.inquire_date "
			+ "from inquire_board a1, user_info a2 where a1.inquire_writer_id = a2.user_id and a1.inquire_idx = #{inquire_idx}")
	InqBoardBean getInqBoardIdx(int inquire_idx);

	

	@Insert("insert into free_board (free_idx, free_title, free_content, free_writer_id, free_date) "
			+ "values (free_seq.nextval, #{free_title}, #{free_content}, #{free_writer_id}, #{free_date}) ")
	void addFreeBoardInfo(FreeBoardBean tempBoardBean);

	@Insert("insert into inquire_board (inquire_idx, inquire_type, inquire_title, inquire_content, inquire_writer_id, inquire_date) "
			+ "values (inq_seq.nextval, #{inquire_type}, #{inquire_title}, #{inquire_content}, #{inquire_writer_id}, #{inquire_date}) ")
	void addInqBoardInfo(InqBoardBean tempBoardBean);



	@Update("update free_board set free_content = #{free_content} where free_idx = #{free_idx}")
	void editFreeBoardInfo(FreeBoardBean tempBoardBean);



	@Delete("delete from free_board where free_idx = #{free_idx}")
	void deleteFreeBoardInfo(int free_idx);

	@Delete("delete from inquire_board where inquire_idx = #{inquire_idx}")
	void deleteInqBoardInfo(int inquire_idx);
	
	
	
	//페이지
	@Select("select count(*) from free_board")
	int countFreeContent();

	
	
	
	// comment-inquire

	@Select("select inquire_idx, inquire_comment, comment_writer, comment_date from inquire_comment where inquire_idx = #{inquire_idx}")
	InqCommentBean getInqCommentIdx(int inquire_idx);

	@Insert("insert into inquire_comment (inquire_idx, inquire_comment, comment_writer, comment_date) "
			+ "values (#{inquire_idx}, #{inquire_comment}, #{comment_writer}, #{comment_date}) ")
	void addInqComment(InqCommentBean tempBoardBean);

	// comment-free
	@Select("select free_idx, free_comment, comment_writer, comment_date from free_comment where free_idx = #{free_idx}")
	List<FreeCommentBean> getFreeCommentIdx(int free_idx);

	@Insert("insert into free_comment (free_idx, free_comment, comment_writer, comment_date) "
			+ "values (#{free_idx}, #{free_comment}, #{comment_writer}, #{comment_date}) ")
	void addFreeComment(FreeCommentBean tempBoardBean);

	// free-comment count - 자유게시판 중 특정 게시글의 댓글 수 가져오기
	@Select("select count(a1.free_idx) as count from free_comment a1, free_board a2"
			+ " where a1.free_idx = a2.free_idx and a2.free_idx = #{free_idx}")
	int countFreeComment(int free_idx);

	// free-board read 호출 시 hit 1증가
	@Update("update free_board set free_hit = free_hit + 1 where free_idx = #{free_idx}")
	int addFreeHit(int free_idx);
	
	// free-board read에서 공감해요 클릭 시 해당 게시물(free_idx)의 좋아요(free_agree) 수 증가
	@Update("update free_board set free_agree = free_agree + 1 where free_idx = #{free_idx}")
	int addFreeAgree(int free_idx);


	
	
}
