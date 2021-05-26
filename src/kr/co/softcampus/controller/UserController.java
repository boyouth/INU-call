package kr.co.softcampus.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.mail.HtmlEmail;
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
		if(loginUserInfo.isLog_in()) return "user/error";
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
		if(!loginUserInfo.isLog_in()) return "user/error";
		session.invalidate();
		loginUserInfo.setLog_in(false);
		
		return "user/logout";
		
	}

	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserInfo") UserBean joinUserInfo) {
		if(loginUserInfo.isLog_in()) return "user/error";
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
	
	@GetMapping("/user_modify")
	public String user_modify(@ModelAttribute("modifyUserInfo") UserBean modifyUserInfo, Model model) {
		if(!loginUserInfo.isLog_in()) return "user/error";
		
		
		userService.getUserInfo_mod(modifyUserInfo);
		String phone_num = modifyUserInfo.getPhone();
		String phone = phone_num.substring(3);
		System.out.println(phone);
		
		model.addAttribute("loginUserInfo",modifyUserInfo);
		model.addAttribute("phone",phone);
		
		
		return "user/user_modify";
	}
	
	@PostMapping("/user_modify_ok")
	public String user_modify_ok(@Valid @ModelAttribute("modifyUserInfo") UserBean modifyUserInfo, HttpServletRequest request) {
		
		String user_id = (String)request.getParameter("user_id");
		String user_name = (String)request.getParameter("user_name");
		String user_pw = (String)request.getParameter("user_pw");
		String email = (String)request.getParameter("email");
		String phone = (String)request.getParameter("phone1") + request.getParameter("phone2");
		
		System.out.println(user_pw + " " + email + " " + phone);
		
		modifyUserInfo.setUser_id(user_id);
		modifyUserInfo.setUser_name(user_name);
		modifyUserInfo.setUser_pw(user_pw);
		modifyUserInfo.setEmail(email);
		modifyUserInfo.setPhone(phone);
		
		userService.modifyUserInfo(modifyUserInfo);
		
		return "user/user_modify_ok";

		
	}
	
	@GetMapping("/find_id")
	public String find_id(@ModelAttribute("tempUserInfo") UserBean tempUserInfo) {
		if(loginUserInfo.isLog_in()) return "user/logout";
		return "user/find_id";
	}
	
	@PostMapping("/find_id_ok")
	public String find_id_ok(@Valid @ModelAttribute("tempUserInfo") UserBean tempUserInfo, Model model, HttpServletRequest request){
		
		String user_name = (String)request.getParameter("name");
		String user_email = (String)request.getParameter("email");
		
		System.out.println(user_name+" "+user_email);
		
		tempUserInfo.setUser_name(user_name);
		tempUserInfo.setEmail(user_email);
		
		boolean check = userService.findUserInfo(tempUserInfo);
		
		
		if(check) {
			model.addAttribute("name",user_name);
			model.addAttribute("id",loginUserInfo.getUser_id());
			
			return "user/find_id_ok";
		}
		else return "user/find_id_fail";
		// 아이디가 있으면 로그인 페이지로 없으면 아이디찾기페이지로(회원정보가없습니다!!)
	}
	
	@GetMapping("find_pw")
	public String find_pw(@ModelAttribute("tempUserInfo") UserBean tempUserInfo) {
		if(loginUserInfo.isLog_in()) return "user/logout";

		return "user/find_pw";
	}
	
	//이메일인증---------------------------------------------------------------------
	public void sendEmail(UserBean userBean, String div) throws Exception{
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		String hostSMTPid = "testforbo0@gmail.com";
		String hostSMTPpwd = "checkingbo0";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "inucall@inu.ac.kr";
		String fromName = "관리자";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "INU@Call 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: #086A87;'>";
			msg += userBean.getUser_id() + "님의 임시 비밀번호 입니다.<br>임시비밀번호를 사용하여 로그인 후 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += userBean.getUser_pw() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = userBean.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}
	@PostMapping("find_pw_ok")
	public String find_pw_ok(@Valid @ModelAttribute("tempUserInfo") UserBean tempUserInfo ,HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		boolean check = userService.findUserInfo(tempUserInfo);
		
		if(check) {
			String pw="";
			for(int i=0;i<7;i++) {
				pw += (char) ((Math.random()*26) + 97);
			}
			for(int i=0;i<3;i++) {
				pw += (int)((Math.random()*10) + 1);
			}
			
			tempUserInfo.setUser_pw(pw);
			userService.giveTempPassword(tempUserInfo);
			sendEmail(tempUserInfo, "findpw");
			
		}
		return "user/find_pw_ok";
	}
	
	
}
