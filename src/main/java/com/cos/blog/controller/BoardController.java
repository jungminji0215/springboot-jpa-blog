package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping({"","/"})
	public String index() {
		// /WEB-INF/views/index.jsp -> 이 경로를 찾아서 넘겨줌 
		return "index";
		
	}
}
