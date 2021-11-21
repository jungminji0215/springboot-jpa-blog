
package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.Getter;
//import lombok.Setter;
//@Getter
//@Setter

//Getter, Setter 동시에 만들라면 @Data 사용해야 한다.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member { 

	private  int id;
	private  String username;
	private  String password;
	private  String email;
	
}



//package com.cos.blog.test;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
////import lombok.Getter;
////import lombok.Setter;
////@Getter
////@Setter
//
////Getter, Setter 동시에 만들라면 @Data 사용해야 한다.
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Member { 
//
//	private  int id;
//	private  String username;
//	private  String password;
//	private  String email;
//	
//}









//package com.cos.blog.test;
//
//public class Member {
//	
//	// 자바에서 변수는 다 private로 만든다
//	// 함수를 통해서 접근해야함
//	private int id;
//	private String username;
//	private String password;
//	private String email;
//	
//	// 생성자
//	public Member(int id, String username, String password, String email) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//}
