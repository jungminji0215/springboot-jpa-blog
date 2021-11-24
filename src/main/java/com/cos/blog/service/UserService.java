package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import ch.qos.logback.core.encoder.Encoder;

// 서비스 왜 필요? -> 트랜잭션 관리, 서비스 의미 때문, 
// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌 (IoC를 해준다.)
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional // 회원가입 전체 서비스가 하나의 트랜잭션으로 묶임, 전체가 성공이 돼야 commit
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); // 1234 원문
		String encPassword = encoder.encode(rawPassword); // 1234 해쉬: $2a$10$Cmjm1RyBDF5MRA1H5pQpEu/BYxmNMiYnU6k6Fd.yH9Ky0UvifuvOi 이렇게 바뀜
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
//	@Transactional(readOnly = true) // Select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
