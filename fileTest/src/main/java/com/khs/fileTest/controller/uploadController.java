package com.khs.fileTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khs.fileTest.model.service.uploadService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("upload")
@RequiredArgsConstructor
public class uploadController {
	
	private final uploadService service;

	@PostMapping("test1")
	public String uploadFile1(
			@RequestParam("uploadFile1") MultipartFile uploadFile,
			RedirectAttributes ra
			) {
		
		String path = service.uploadFile1(uploadFile);
		
		
		
		return "redirect:/";
	}
	
}
