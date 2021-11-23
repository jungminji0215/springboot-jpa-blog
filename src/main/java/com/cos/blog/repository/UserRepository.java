package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

// JpaRepository<User, Integer> 의 의미 -> JpaRepository는 User 테이블을 관리하는 Repository
// 그리고 User 테이블의 PK는 Integer이다..
public interface UserRepository extends JpaRepository<User, Integer>{
	//이렇게 만들어지면 JpaRepository는 findAll() 이라는 함수를 가지고 있어
	// findAll() -> User 테이블이 들고 있는 모든 행을 다 리턴해준다.
	// 그뿐만 아니라 아주 많은 기능이 있음! 그래서 기본적인 CRUD도 당연히 다 가능
	// JSP로 치면 DAO 역할임. 

	// 이렇게 하면 bean으로 등록이 되나요? ( bean으로 등록된다는 것은, 스프링 IoC에서 객체를 가지고 있나요?) 
	// (bean으로 등록되면 우리가 필요할 때마다 DI를 할 수 있다.)
	// 위에 대한 답변 -> 등록된다. (자동으로 bean 등록이 된다) 그래서 @Repository 생략할 수 있다.
	
	
	// JPA Naming 전략
	// findByUsernameAndPassword 이런 이름으로 함수 만들면 
	// SLELCT * FROM user WHERE username = ? AND password = ?;  이런 쿼리가 동작함
	// ?에는 파라미터로 들어온 애들이 들어감 
	User findByUsernameAndPassword(String username, String password);
	
//	@Query(value="SLELCT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String password);
	
}