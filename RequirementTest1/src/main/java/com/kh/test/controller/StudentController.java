package com.kh.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.model.dto.Student;
import com.kh.test.model.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class StudentController {
	
	private final StudentService service;

	
	@ResponseBody 
	@GetMapping("search")
	public List<Student> search() {
		
		
		List<Student> studentList = service.selectList();
		
		
		
		
		return studentList;
	}
	
	
	
}
