package kr.co.softcampus.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import kr.co.softcampus.beans.PhoneBookBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/phone_book")
	public String phone_book(Model model) {
		
		List<PhoneBookBean> phone_book = boardService.getPhoneBookInfo();
		
		int len = phone_book.size();
		
		for(int i=0;i<len;i++) {
			System.out.println(phone_book.get(i).getList_writer_name());
		}
		
		model.addAttribute("phone_book",phone_book);
		
		
		return "board/phone_book";
	}
	
	@GetMapping("/phone_book_read")
	public String phone_book_read(@RequestParam("list_idx") int list_idx, Model model) {
		
		model.addAttribute("list_idx",list_idx);
		
		PhoneBookBean list_info = boardService.getPhoneBookIdx(list_idx);
		
		model.addAttribute("list_info",list_info);
		
		System.out.println(list_info.getList_content());
		
		return "board/phone_book_read";
	}
	
	@GetMapping("/free_board")
	public String free_board() {
		return "board/free_board";
	}
	
	@GetMapping("/inquire_board")
	public String inquire_book() {
		return "board/inquire_board";
	}
	
	@GetMapping("/write_new_phone")
	public String write_new_phone(@ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo) {
		return "board/write_new_phone";
	}
	
	@PostMapping("/write_phone_ok")
	public String write_phone_ok(@Valid @ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo, HttpServletRequest request) {
		
		String user_id = (String)request.getParameter("user_id");
		String list_depart = (String)request.getParameter("title");
		String list_content = (String)request.getParameter("content");

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String list_date = new SimpleDateFormat("YYYY-MM-dd").format(date);
		
		System.out.println(user_id + " " + list_depart + " " + list_content + " " + list_date);
		
		phoneBookInfo.setList_writer_id(user_id);
		phoneBookInfo.setList_depart(list_depart);
		phoneBookInfo.setList_content(list_content);
		phoneBookInfo.setList_date(list_date);
		
		boardService.addPhoneBookInfo(phoneBookInfo);	
		
		return "board/write_phone_ok";
	}
	
	@GetMapping("/phone_book_edit")
	public String phone_book_edit(@ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo, @RequestParam("title") String title,
								  @RequestParam("list_idx") int list_idx,
								  HttpServletRequest request, Model model) {
		model.addAttribute("list_depart",title);
		model.addAttribute("list_idx",list_idx);
		
		
		
		return "board/phone_book_edit";
	}
	
	@PostMapping("/edit_phone_ok")
	public String edit_phone_ok(@Valid @ModelAttribute("phoneBookInfo") PhoneBookBean phoneBookInfo, @RequestParam("list_idx") int list_idx, 
								HttpServletRequest request, Model model) {
		model.addAttribute("list_idx",list_idx);
		

		String list_content = (String)request.getParameter("content");
		
		phoneBookInfo.setList_idx(list_idx);
		phoneBookInfo.setList_content(list_content);
		
		boardService.editPhoneBookInfo(phoneBookInfo);
		
		return "board/edit_phone_ok";
	}
	
	@GetMapping("/phone_book_delete")
	public String phone_book_delete(@RequestParam("list_idx") int list_idx) {	
		
		boardService.deletePhoneBookInfo(list_idx);

		return "board/phone_book_delete";
	}
	

}
