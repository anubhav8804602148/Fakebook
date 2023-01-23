package com.ashar.fakebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/")
	public String showWelcomePage() {
		return "welcome.html";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
