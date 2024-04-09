package com.khs.book.deleteUpdate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khs.book.model.dto.Book;
import com.khs.book.model.service.MainService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("deleteUpdate")
public class DeleteUpdateController {
	
	private final MainService service;
	
	@GetMapping("page")
	public String page () {
		
		return "deleteUpdate/page";
	}
	
	@ResponseBody
	@GetMapping("detailSearch")
	public List<Book> detailSearch (
			@RequestParam("searchBookName") String bookTitle,
			RedirectAttributes ra
			
			) {
		
		List<Book> detailList = service.detailSearch(bookTitle);
		
		
		ra.addFlashAttribute("detailList", detailList);
		
		return detailList;
	}
	
	

}
