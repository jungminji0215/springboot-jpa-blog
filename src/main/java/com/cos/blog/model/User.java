package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// ORM이란? JAVA(다른언어 포함) Object를 테이블로 매핑해주는 기술 
// 클래스를 테이블화 하려면 @Entity를 붙여야 한다. 
// 이를 붙이면 User클래스가 스프링부트가 실행될때 User class를 통해서
// User 클래스의 id username password email createDate를 읽어서
// 자동으로 MySQL에 테이블을 생성해준다

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class User {
	
	// @id 붙이면 primary Key 가 됨 
	@Id 
	// @GeneratedValue : 넘버링 전략 // IDENTITY : 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	//즉, 오라클을 사용한다면 시퀀스를 사용하는 것이고, mysql을 사용하면  auto_increment를 사용한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	// nullable = false:  null이 될수 없다
	// length = 20 길이
	// unique = true -> 중복 안 되게
	@Column(nullable = false, length = 20, unique = true) 
	private String username; // 네이버 아이디 뭐야? 할때 그 id
	
	@Column(nullable = false, length = 100) // 길이가 100인 이유는 나중에 1234 해쉬로 변경해서 비밀번호 암호화할거야 암호화된 비번을 DB에 넣을거야
	private String password;
	
	@Column(nullable = false, length = 50) 
	private String email;
	
	
	// @ColumnDefault("'user'") // 회원가입할 때 default 값은 user가 된다. 참고로 문자열이면  (" 'user' ") 이렇게 사용
	// private String role; 이렇게말고 Enum을 쓰는게 좋다.
	
	// Enum 사용하면 도메인 설정할 수 있다
	// 도메인이 정해졌다 : 범위가 정해졌다.
	@Enumerated(EnumType.STRING) // DB는 RoleType없어서 해당 enum이 String라는 것을 알려주어야 하 
	private RoleType role;
	// 어렵,,
	
	// 가입한 시간
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
	
	// 회원가입할 때 id와 createDate는 비워나도된다. 자동으로 들어가니까 
}