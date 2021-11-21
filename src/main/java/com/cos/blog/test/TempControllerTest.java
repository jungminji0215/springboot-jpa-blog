package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller -> 데이터를 리턴하지 않고 파일을 리턴할거야!
@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		
		//파일 리턴 기본경로 : src/main/resources/static
		return "/home.html";
	}
	
	// http://localhost:8000/blog/temp/jsp
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix : /WEB-INF/views/
		// suffic : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		
		return "test";
	}
}
