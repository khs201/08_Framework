package com.khs.fileTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("signup")
@Controller
public class SignupController {
	
	
	@GetMapping("signupPage")
	public String signupPage() {
		
		
		return "signupPage";
	}
	
}
