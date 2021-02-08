package com.itcast.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itcast.admin.entity.User;

@Controller
public class TableController {

	@GetMapping("/basic_table")
	public String basic_table() {

		return "table/basic_table";
	}

	@GetMapping("/dynamic_table")
	public String dynamic_table(Model model) {
		List<User> users = Arrays.asList(new User("su", "123456"), new User("wong", "12688"), new User("c8c8", "aaaa"));

		model.addAttribute("users", users);
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
