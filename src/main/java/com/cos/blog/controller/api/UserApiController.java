package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

// 이것은 나중에 앱에서도 쓸 수 있음 
@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	


	// localhost:8000/blog/api/user
	@PostMapping("/auth/joinProc")
	public  ResponseDto<Integer> save(@RequestBody User user) { // username, password, email을 받아 옴 role는 직접 넣어야함
		System.out.println("UserApiController : save 호출됨");
	
		
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 된다.
	
		userService.회원가입(user); // 1이면 성공 -1이면 실패
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1) ;
	}
	
	// 전통적인 방식의 로그인 방법
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("UserApiController : login호출됨");
//		User principal = userService.로그인(user); // principal (접근주체)
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal); // session 만들어짐
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1) ;
//	}
	
}
