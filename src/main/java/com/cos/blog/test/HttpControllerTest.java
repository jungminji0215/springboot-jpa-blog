///////////////////// 실습4 /////////////////////
package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest: ";
	
	// http://localhost:8080/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() { 

		Member m = new Member(1,"minji","1234","email");

		System.out.println(TAG + "getter : " + m.getUsername());
		m.setId(5000);
		System.out.println(TAG + "setter : " + m.getId());
		return "lombok test 완료";	
	}
	
	// 실제 주소 -> http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTset(Member m) {
		return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword();
	}
	
	// 실제 주소 -> http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTset(Member m) {
		return "post 요청" + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// 실제 주소 -> http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTset() {
		return "put 요청";
	}
	
	// 실제 주소 -> http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTset() {
		return "delete 요청";
	}
	
}








/////////////////////// http 실습3 /////////////////////
//package com.cos.blog.test;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HttpControllerTest {
//	
//	// 실제 주소 -> http://localhost:8080/http/get
//	@GetMapping("/http/get")
//	public String getTset(Member m) {
//		return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword();
//	}
//	
//	// 실제 주소 -> http://localhost:8080/http/post
//	@PostMapping("/http/post")
//	public String postTset(Member m) {
//		return "post 요청" + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//	}
//	
//	// 실제 주소 -> http://localhost:8080/http/put
//	@PutMapping("/http/put")
//	public String putTset() {
//		return "put 요청";
//	}
//	
//	// 실제 주소 -> http://localhost:8080/http/delete
//	@DeleteMapping("/http/delete")
//	public String deleteTset() {
//		return "delete 요청";
//	}
//	
//}







/////////////////////// 실습2 /////////////////////
//package com.cos.blog.test;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class HttpControllerTest {
//	
//	// http://localhost:8080/http/get
//	@GetMapping("/http/get")
//	public String getTset(@RequestParam int id, @RequestParam String username) {
//		return "get 요청: " + id + ", " + username;
//	}
//	
//	// http://localhost:8080/http/post
//	@PostMapping("/http/post")
//	public String postTset() {
//		return "post 요청";
//	}
//	
//	// http://localhost:8080/http/put
//	@PutMapping("/http/put")
//	public String putTset() {
//		return "put 요청";
//	}
//	
//	// http://localhost:8080/http/delete
//	@DeleteMapping("/http/delete")
//	public String deleteTset() {
//		return "delete 요청";
//	}
//	
//}




/////////////////////// 실습1 /////////////////////
//package com.cos.blog.test;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//// 사용자가 요청했을 때 -> 응답을 HTML 파일로 하려면
//// @Controller 사용
//
//// 사용자가 요청했을 때 -> 응답을 Data로 받을라면
//// @RestController 사용
//
//@RestController
//public class HttpControllerTest {
//	
//	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
//	
//	// http://localhost:8080/http/get
//	@GetMapping("/http/get")
//	public String getTset() {
//		return "get 요청";
//	}
//	
//	// http://localhost:8080/http/post
//	@PostMapping("/http/post")
//	public String postTset() {
//		return "post 요청";
//	}
//	
//	// http://localhost:8080/http/put
//	@PutMapping("/http/put")
//	public String putTset() {
//		return "put 요청";
//	}
//	
//	//  http://localhost:8080/http/delete
//	@DeleteMapping("/http/delete")
//	public String deleteTset() {
//		return "delete 요청";
//	}
//}
