package com.khs.book.addBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khs.book.model.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("addBook")
public class addBookController {
	
	private final MainService service;
	
	@GetMapping("addPage")
	public String addPage() {
		
		
		return "addPage/addPage";
	}
	
	@PostMapping("addBook")
	public String addBook(
			RedirectAttributes ra,
			@RequestParam("addBookPrice") int bookPrice,
			@RequestParam("addBookWriter") String bookWriter,
			@RequestParam("addBookName") String bookTitle
			
			) {
		
		int result = service.addBook(bookPrice, bookWriter, bookTitle);
		String message = null;
		String path = null;
		
		if(result > 0){
			message = "등록 성공";
			path = "redirect:/"; 
		} else {
			message = "등록 실패";
			path = "redirect:/addPage/addPage";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
		
	}

}
