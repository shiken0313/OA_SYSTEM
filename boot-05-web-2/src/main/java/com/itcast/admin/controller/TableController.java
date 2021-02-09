package com.itcast.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcast.admin.entity.User;
import com.itcast.admin.service.UserService;

@Controller
public class TableController {
	
	
	@Autowired
	private UserService userServie;
	
	
	@GetMapping("/basic_table")
	public String basic_table() {

		return "table/basic_table";
	}
	
	@GetMapping("user/delete/{id}")
	public String deleteUser(@PathVariable("id")Long id,
							@RequestParam(value = "pn",defaultValue = "1")Integer pn,
							RedirectAttributes ra) {
		
		userServie.removeById(id);
		ra.addAttribute("pn",pn);
		
		return "redirect:/dynamic_table";
	}
	
	@GetMapping("/dynamic_table")
	public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
		Page<User> userPage = new Page<User>(pn,2);
		Page<User> page = userServie.page(userPage,null);
		model.addAttribute("page",page);
		return "table/dynamic_table";
	}

	@GetMapping("/responsive_table")
	public String responsive_table() {

		return "table/responsive_table";
	}

	@GetMapping("/editable_table")
	public String editable_table() {

		return "table/editable_table";
	}
}
