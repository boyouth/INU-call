package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/phone_book")
	public String phone_book() {
		return "board/phone_book";
	}
	
	
	@GetMapping("/free_board")
	public String free_board() {
		return "board/free_board";
	}
	
	@GetMapping("/inquire_book")
	public String inquire_book() {
		return "board/inquire_book";
	}
	

}
