package com.khs.book.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khs.book.model.dto.Book;
import com.khs.book.model.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final MainService service;
	
	@RequestMapping("/")
	public String mainPage() {
		
		return "main";
	}
	
	@ResponseBody
	@GetMapping("search")
	public List<Book> search() {
		
		List<Book> bookList = service.search();
		
		return bookList;
	}

}
