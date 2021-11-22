package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// 서비스 왜 필요? -> 트랜잭션 관리, 서비스 의미 때문, 
// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌 (IoC를 해준다.)
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional // 회원가입 전체 서비스가 하나의 트랜잭션으로 묶임, 전체가 성공이 돼야 commit
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1; // 정상이면 1 리턴
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() :" + e.getMessage());
		}
		return -1;	 // save 하나가 오류나면 -1 리턴
	}
}
