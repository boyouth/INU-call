package kr.co.softcampus.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Resource(name="loginUserInfo")
	private UserBean loginUserInfo;

	@GetMapping("/checkId")
	@ResponseBody
	public boolean checkId(@RequestParam("user_id") String user_id) {
		return userService.checkId(user_id);
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tempUserInfo") UserBean tempUserInfo) {
		
		return "user/login";
	}
	
	@PostMapping("/login_ok")
	public String login_ok(@Valid @ModelAttribute("tempUserInfo") UserBean tempUserInfo, HttpServletRequest request, Model model) {
		String user_id = (String)request.getParameter("user_id");
		String user_pw = (String)request.getParameter("user_pw");
		
		System.out.println(user_id+" "+user_pw);
		
		tempUserInfo.setUser_id(user_id);
		tempUserInfo.setUser_pw(user_pw);
		
		userService.getUserInfo(tempUserInfo);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUserInfo", loginUserInfo);
		
		if(loginUserInfo.isLog_in()) {
			
			return "user/login_ok";
		}
		else return "user/login_fail";
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		loginUserInfo.setLog_in(false);
		
		return "user/logout";
		
	}

	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserInfo") UserBean joinUserInfo) {

		return "user/join";
	}

	@PostMapping("/join_ok")
	public String join_ok(@Valid @ModelAttribute("joinUserInfo") UserBean joinUserInfo, HttpServletRequest request) {

		
		String user_id = (String)request.getParameter("user_id");
		String user_name = (String)request.getParameter("user_name");
		String user_pw = (String)request.getParameter("user_pw");
		String email = (String)request.getParameter("email");
		String phone = (String)request.getParameter("phone1") + request.getParameter("phone2");

		System.out.println(user_id + " " + user_name + " " + user_pw + " " + email + " " + phone);

		/*
		 * boolean exist_id = userService.checkId(user_id); if (exist_id) return
		 * "user/join_fail";
		 */

		joinUserInfo.setUser_id(user_id);
		joinUserInfo.setUser_name(user_name);
		joinUserInfo.setUser_pw(user_pw);
		joinUserInfo.setEmail(email);
		joinUserInfo.setPhone(phone);

		userService.addUserInfo(joinUserInfo);

		return "user/join_ok";
	}
}
