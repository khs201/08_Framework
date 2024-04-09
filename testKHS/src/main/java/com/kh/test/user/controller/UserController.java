package com.kh.test.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@GetMapping("search")
	public String search(@RequestParam("searchUserId") String userId, Model model) {

		List<User> searchList = service.search(userId);
		
		String path = null;
		
		if (!searchList.isEmpty()) { // 조회 결과가 있을 경우
			path = "/searchSuccess"; // 성공 페이지로 이동
			model.addAttribute("searchList", searchList);
		} else { // 조회 결과가 없을 경우
			path = "/searchFail"; // 실패 페이지로 이동
		}

		return path;
		
		
		
		
		
		
		
		

		
		
		
		

	}
	

}
