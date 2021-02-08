package com.itcast.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itcast.admin.entity.User;

@Controller
public class IndexController {
	/**
	 * login画面
	 * 
	 * @return
	 */
	@GetMapping(value = { "/", "/login" })
	public String loginPage() {

		return "login";
	}

	/**
	 * メイン画面に移遷
	 * 
	 * @param userName
	 * @param password パスワード
	 * @return
	 */
	@PostMapping("/login")
	public String main(User user, HttpSession session,Model model) {
		
		if (StringUtils.hasLength(user.getUserName()) &&
			StringUtils.hasLength(user.getPassword())) {
			//userをsessionに保存
			session.setAttribute("loginUser", user);
			
			return "redirect:main.html";
		}else {
			model.addAttribute("msg", "登入失敗請重新輸入");
			
			return "login";
		}
			
	}

	/**
	 * メイン画面に移遷
	 * 
	 * @return
	 */
	@GetMapping("main.html")
	public String mainPage(HttpSession session,Model model) {
		Object loginUser = session.getAttribute("loginUser");
		if(loginUser != null) {
			return "main";
		}else {
			model.addAttribute("msg", "請重新登入");
			return "login";
		}
		
	}
}
