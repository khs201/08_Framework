package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardNameInterceptor;
import edu.kh.project.common.interceptor.BoardTypeInterceptor;
import lombok.extern.slf4j.Slf4j;

// 인터셉터가 어떤 요청을 가로챌지 설정하는 클래스

@Slf4j
@Configuration // 서버가 켜지면 내부 메서드를 모두 수행
public class InterceptorConfig implements WebMvcConfigurer{

	// 인터셉터 클래스 Bean 등록
	@Bean // 개발자가 만들어서 반환하는 객체를 Bean 등록
		  // -> 관리는 Spring Container가 수행
	public BoardTypeInterceptor boardTypeInterceptor() {
		return new BoardTypeInterceptor();
	}
	
	@Bean
	public BoardNameInterceptor boardNameInterceptor() {
		
		return new BoardNameInterceptor();
	}
	

	// 동작할 인터셉터 객체를 추가하는 메서드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Bean으로 등록된 BoardTypeInterceptor를 얻어와 매개변수로 전달
		registry.addInterceptor( boardTypeInterceptor() )
		.addPathPatterns("/**") // 가로챌 요청 주소를 지정
							    // 여러 주소 작성 시 "", "" 콤마로 구분		
							    // /** : /이하 모든 요청 주소
		.excludePathPatterns(
				"/css/**", 
				"/js/**", 
				"/images/**", 
				"/favicon.ico"); // 가로채지 않을 주소를 지정
		
		// Bean으로 등록된 BoardNameInterceptor 객체를 얻어와
		// 인터셉터로 등록
		registry.addInterceptor(boardNameInterceptor())
		.addPathPatterns("/board/**", "/editBoard/**");
		
		
		
	}
	
	
	
	
	
}
