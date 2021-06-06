package kr.co.softcampus.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.softcampus.beans.FreeBoardBean;
import kr.co.softcampus.beans.FreeCommentBean;
import kr.co.softcampus.beans.FreeLikeBean;
import kr.co.softcampus.beans.InqBoardBean;
import kr.co.softcampus.beans.InqCommentBean;
import kr.co.softcampus.beans.PageBean;
import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Resource(name = "loginUserInfo")
	private UserBean loginUserInfo;

	@GetMapping("/phone_book")
	public String phone_book(Model model) {

		List<PhoneBookBean> phone_book = boardService.getPhoneBookInfo();
		model.addAttribute("phone_book", phone_book);

		return "board/phone_book";
	}

	@GetMapping("/phone_book_all")
	public String phone_book_all(Model model) {

		List<PhoneBookBean> all = boardService.getPhoneBookInfoAll();
		model.addAttribute("all_info", all);

		return "board/phone_book_all";
	}

	@GetMapping("/phone_book_read")
	public String phone_book_read(@RequestParam("school") String school, Model model) {

		System.out.println(school);

		List<PhoneBookBean> majors = boardService.readPhoneBook(school);

		for (int i = 0; i < majors.size(); i++) {
			System.out.println(majors.get(i).getMajor());
		}
		model.addAttribute("school", school);
		model.addAttribute("majors", majors);

		return "board/phone_book_read";
	}

	@GetMapping("/free_board")
	public String free_board(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<FreeBoardBean> free_board = boardService.getFreeBoardInfo(page);

		int len = free_board.size();

		for (int i = 0; i < len; i++) {
			int idx = free_board.get(i).getFree_idx();
			int count_comment = boardService.countFreeComment(idx);
			free_board.get(i).setFree_comment_cnt(count_comment);
		}

		model.addAttribute("free_board", free_board);

		PageBean pageBean = boardService.countFreeContent(page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("page", page);

		return "board/free_board";
	}
	
	@GetMapping("/free_comment_delete")
	public String free_comment_delete(@RequestParam("free_idx") int free_idx, @RequestParam("comment_idx") int comment_idx,Model model) {
		
		boardService.deleteFreeComment(free_idx, comment_idx);
		
		model.addAttribute("free_idx",free_idx);
		
		return "board/free_comment_delete";
	}

	@GetMapping("/free_board_read")
	public String free_board_read(@RequestParam("free_idx") int free_idx,
			@ModelAttribute("freeCommentInfo") FreeCommentBean freeCommentInfo, Model model) {

		if (!loginUserInfo.isLog_in())
			return "user/error";

		model.addAttribute("free_idx", free_idx);

		int hit = boardService.addFreeHit(free_idx);
		FreeBoardBean free_info = boardService.getFreeBoardIdx(free_idx);
		List<FreeCommentBean> free_comment = boardService.getFreeCommentIdx(free_idx);

		System.out.println("hit:"+hit);
		model.addAttribute("free_info", free_info);


		if (free_comment.isEmpty()) {
			model.addAttribute("empty1", "댓글이 없습니다.");
		} else {
			model.addAttribute("free_comment", free_comment);
			model.addAttribute("empty1", "");
		}
		
		List<FreeLikeBean> free_like = boardService.getFreeLikeInfo(free_idx, loginUserInfo.getUser_id());
		
		System.out.println("size:"+free_like.size());
		
		if(free_like.size()==0) {
			model.addAttribute("like",0);
		}
		else if(free_like.size()>0) {
			int like = free_like.get(0).getLikey();
			model.addAttribute("like",like);
		}

		int cnt = boardService.countFreeLike(free_idx);
		model.addAttribute("count_like",cnt);
		
		
		return "board/free_board_read";
	}

	@GetMapping("/inquire_board")
	public String inquire_book(Model model) {

		if (!loginUserInfo.isLog_in())
			return "user/error";

		List<InqBoardBean> inquire_board = boardService.getInqBoardInfo();

		int len = inquire_board.size();

		for (int i = 0; i < len; i++) {
			System.out.println(inquire_board.get(i).getInquire_writer_name());
		}

		model.addAttribute("inquire_board", inquire_board);

		return "board/inquire_board";
	}

	@GetMapping("/inquire_board_read")
	public String inquire_board_read(@RequestParam("inquire_idx") int inquire_idx,
			@ModelAttribute("inqCommentInfo") InqCommentBean inqCommentInfo, Model model) {

		System.out.println(inquire_idx);
		if (!loginUserInfo.isLog_in())
			return "user/error";

		model.addAttribute("inquire_idx", inquire_idx);

		InqBoardBean inquire_info = boardService.getInqBoardIdx(inquire_idx);
		InqCommentBean inquire_comment = boardService.getInqCommentIdx(inquire_idx);

		model.addAttribute("inquire_info", inquire_info);

		if (inquire_comment == null) {
			model.addAttribute("empty1", "고객님들의 문의사항을 확인중입니다. ^-^");
		} else {
			model.addAttribute("inquire_comment", inquire_comment);
			model.addAttribute("empty1", "");
		}

		return "board/inquire_board_read";
	}

	@GetMapping("/write_new_phone")
	public String write_new_phone(@ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo) {
		return "board/write_new_phone";
	}

	@GetMapping("/write_new_free")
	public String write_new_free(@ModelAttribute("freeBoardInfo") FreeBoardBean freeBoardInfo) {
		return "board/write_new_free";
	}

	@GetMapping("/write_new_inquire")
	public String write_new_free(@ModelAttribute("inqBoardInfo") InqBoardBean inqBoardInfo) {
		if (!loginUserInfo.isLog_in())
			return "user/error";

		return "board/write_new_inquire";
	}

	@PostMapping("/write_phone_ok")
	public String write_phone_ok(@Valid @ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo,
			HttpServletRequest request) {

		return "board/write_phone_ok";
	}

	@PostMapping("/write_free_ok")
	public String write_free_ok(@Valid @ModelAttribute("freeBoardInfo") FreeBoardBean freeBoardInfo,
			HttpServletRequest request) {

		String user_id = (String) request.getParameter("user_id");
		String free_title = (String) request.getParameter("title");
		String free_content = (String) request.getParameter("content");

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String free_date = new SimpleDateFormat("YYYY-MM-dd").format(date);

		System.out.println(user_id + " " + free_title + " " + free_content + " " + free_date);

		freeBoardInfo.setFree_writer_id(user_id);
		freeBoardInfo.setFree_title(free_title);
		freeBoardInfo.setFree_content(free_content);
		freeBoardInfo.setFree_date(free_date);

		boardService.addFreeBoardInfo(freeBoardInfo);

		return "board/write_free_ok";
	}

	@PostMapping("/write_inquire_ok")
	public String write_phone_ok(@Valid @ModelAttribute("inqBoardInfo") InqBoardBean inqBoardInfo,
			HttpServletRequest request) {

		String user_id = (String) request.getParameter("user_id");
		String inquire_type = (String) request.getParameter("type");
		String inquire_title = (String) request.getParameter("title");
		String inquire_content = (String) request.getParameter("content");

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String inquire_date = new SimpleDateFormat("YYYY-MM-dd").format(date);

		System.out.println(user_id + " " + inquire_type + " " + inquire_title + " " + inquire_content);

		inqBoardInfo.setInquire_writer_id(user_id);
		inqBoardInfo.setInquire_type(inquire_type);
		inqBoardInfo.setInquire_title(inquire_title);
		inqBoardInfo.setInquire_content(inquire_content);
		inqBoardInfo.setInquire_date(inquire_date);

		boardService.addInqBoardInfo(inqBoardInfo);

		return "board/write_inquire_ok";
	}

	@PostMapping("/write_comment_inq")
	public String write_comment_inq(@Valid @ModelAttribute("inqCommentInfo") InqCommentBean inqCommentInfo,
			@RequestParam("inquire_idx") int inquire_idx, HttpServletRequest request, Model model) {

		String inquire_comment = request.getParameter("comment");
		String comment_writer = loginUserInfo.getUser_name();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String comment_date = new SimpleDateFormat("YYYY-MM-dd").format(date);

		System.out.println(inquire_idx + "-" + inquire_comment.trim() + "-" + comment_writer + "-" + comment_date);

		inqCommentInfo.setInquire_idx(inquire_idx);
		inqCommentInfo.setInquire_comment(inquire_comment.trim());
		inqCommentInfo.setComment_writer(comment_writer);
		inqCommentInfo.setComment_date(comment_date);

		boardService.addInqComment(inqCommentInfo);

		model.addAttribute("inquire_idx", inquire_idx);

		return "board/write_comment_inq";

	}

	@PostMapping("/write_comment_free")
	public String write_comment_inq(@Valid @ModelAttribute("freeCommentInfo") FreeCommentBean freeCommentInfo,
			@RequestParam("free_idx") int free_idx, HttpServletRequest request, Model model) {

		String free_comment = request.getParameter("comment");
		String comment_writer = loginUserInfo.getUser_name();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String comment_date = new SimpleDateFormat("YYYY-MM-dd").format(date);

		System.out.println(free_idx + "-" + free_comment.trim() + "-" + comment_writer + "-" + comment_date);

		freeCommentInfo.setFree_idx(free_idx);
		freeCommentInfo.setFree_comment(free_comment.trim());
		freeCommentInfo.setComment_writer(comment_writer);
		freeCommentInfo.setComment_date(comment_date);

		boardService.addFreeComment(freeCommentInfo);

		model.addAttribute("free_idx", free_idx);

		return "board/write_comment_free";

	}

	@GetMapping("/phone_book_edit")
	public String phone_book_edit(@ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo,
			@RequestParam("title") String title, @RequestParam("list_idx") int list_idx, HttpServletRequest request,
			Model model) {
		model.addAttribute("list_depart", title);
		model.addAttribute("list_idx", list_idx);

		return "board/phone_book_edit";
	}

	@GetMapping("/free_board_edit")
	public String free_board_edit(@ModelAttribute("freeBoardInfo") FreeBoardBean freeBoardInfo,
			@RequestParam("title") String title, @RequestParam("free_idx") int free_idx, HttpServletRequest request,
			Model model) {
		model.addAttribute("free_title", title);
		model.addAttribute("free_idx", free_idx);

		return "board/free_board_edit";
	}

	@PostMapping("/edit_phone_ok")
	public String edit_phone_ok(@Valid @ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo,
			@RequestParam("list_idx") int list_idx, HttpServletRequest request, Model model) {

		return "board/edit_phone_ok";
	}

	@PostMapping("/edit_free_ok")
	public String edit_free_ok(@Valid @ModelAttribute("freeBoardInfo") FreeBoardBean freeBoardInfo,
			@RequestParam("free_idx") int free_idx, HttpServletRequest request, Model model) {
		model.addAttribute("free_idx", free_idx);

		String free_content = (String) request.getParameter("content");

		freeBoardInfo.setFree_idx(free_idx);
		freeBoardInfo.setFree_content(free_content);

		boardService.editFreeBoardInfo(freeBoardInfo);

		return "board/edit_free_ok";
	}

	@GetMapping("/phone_book_delete")
	public String phone_book_delete(@RequestParam("list_idx") int list_idx) {

		return "board/phone_book_delete";
	}

	@GetMapping("/free_board_delete")
	public String free_board_delete(@RequestParam("free_idx") int free_idx) {

		boardService.deleteFreeBoardInfo(free_idx);

		return "board/free_board_delete";
	}

	@GetMapping("/inquire_board_delete")
	public String inquire_board_delete(@RequestParam("inquire_idx") int inquire_idx) {

		boardService.deleteInqBoardInfo(inquire_idx);
		;

		return "board/inquire_board_delete";
	}

	@GetMapping("/search")
	public String search(@RequestParam("word") String word, Model model) {

		List<PhoneBookBean> search_result = boardService.searchAll(word);
		model.addAttribute("result", search_result);

		return "board/search";
	}
	
	@GetMapping("/search_free")
	public String search_free(@RequestParam("sort") int sort,
							@RequestParam("word") String word,
							Model model) {

		
		
		List<FreeBoardBean> search_result = null;
		if(sort==0) { // 제목
			search_result = boardService.searchFreeTitle(word);
		}
		else if(sort==1) { // 내용
			search_result = boardService.searchFreeContent(word);
		}
		else if(sort==2) { // 제목+내용
			search_result = boardService.searchFreeAll(word);
		}
		
		model.addAttribute("result", search_result);


		return "board/search_free";
	}
	
	

	@PostMapping("/free_like")
	@ResponseBody
	public int addFreeLike(FreeLikeBean temp, Model model) {
		System.out.println("like:" + temp.getLikey() + " userid:" + temp.getUser_id() + " idx:" + temp.getFree_idx());

		List<FreeLikeBean> free_like = boardService.getFreeLikeInfo(temp.getFree_idx(), temp.getUser_id());
		if(free_like.size()==0) {
			boardService.addFreeLike(temp);
		}
		else if(free_like.size()==1) {
			boardService.editFreeLike(temp.getLikey(), temp.getFree_idx(), temp.getUser_id());
		}
		return temp.getLikey();
	}

}
