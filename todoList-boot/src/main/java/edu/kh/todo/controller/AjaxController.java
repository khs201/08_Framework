package edu.kh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.todo.model.service.TodoService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("ajax")
@Controller
@Slf4j
public class AjaxController {

	// @Autowired
	// - 등록된 bean 중 같은 타입 또는 상속관계 bean을
	// 해당 필드에 의존성 주입 (DI)
	@Autowired
	private TodoService service;

	@GetMapping("main")
	public String ajaxMain() {

		return "ajax/main";
	}

	
	/* @ResponseBody
	 * - 컨트롤러 메서드의 반환 값을
	 * HTTP 응답 본문에 직접 바인딩하는 역할임을 명시
	 * 
	 * (쉬운 해석)
	 * -> 컨트롤러 메서드의 반환 값을
	 * 비동기(ajax) 요청했던 HTML/JS 파일 부분에 값을 돌려 보낼 것이다를 명시
	 * 
	 * - forward/redirect로 인식 X
	 * 
	 * */
	
	
	
	
	// 전체 Todo 개수 조회
	// -> forward / redirect를 원하는 것이 아님!!!
	// -> "전체 Todo 개수"라는 데이터가 반환되는 것을 원함!!!
	@ResponseBody // 값 그대로 돌려 보낼꺼야!!!!!
	@GetMapping("totalCount")
	public int getTotalCount() {

		log.info("getTotalCount 메서드 호출됨!!!!");
		
		int totalCount = 12;
		
		return totalCount;
	}

}
