package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// 어떤 파일에서 Exception이 발생하든지 간에
// 이 클래스로 옴 
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String hangleArgumentException(Exception e) {
		return "<h1>" + e.getMessage() + "</h1>";
		
	}

}
