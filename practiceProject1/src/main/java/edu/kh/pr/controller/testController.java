package edu.kh.pr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("test")
public class testController {

	@GetMapping("1")
	public String test1 (Model model) {
		
		model.addAttribute("str", "<h1>테스트 중 &times; </h1>");
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		model.addAttribute("fruitList", fruitList);
		
		model.addAttribute(fruitList);
		
		return "test1";
	}
	
	
	
	
	
}
