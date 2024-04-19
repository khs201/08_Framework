package com.kh.test.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
	@RequestMapping("search")
	public String search(
			@RequestParam("searchInput") String inputTitle,
			Model model
			)	 {
		
		List<Board> searchList = service.search(inputTitle);
		
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
