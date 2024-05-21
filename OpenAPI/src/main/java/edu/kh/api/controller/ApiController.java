package edu.kh.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

	@GetMapping("ex1")
	public String ex1() {

		
		return "ex1";
	}
	
	
	
}
