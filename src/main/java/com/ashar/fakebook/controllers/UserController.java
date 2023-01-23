package com.ashar.fakebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashar.fakebook.entities.User;

@Controller
public class UserController {

	@GetMapping("/register")
	public String showRegisterUserPage(Model model, User user) {
		model.addAttribute("user", new User());
		return "register.html";
	}
}
