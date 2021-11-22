package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	// 일단 처음에 userRepository는 null이다.
	// 스프링이. @RestController를 읽어서 DummyControllerTest 클래스를 메모리에 올릴 때 null이야
	// 이때 @Autowired를 붙여주면 DummyControllerTest가 메모리에 올라갈 때 @Autowired도 메모리에 같이 올라간다 
	// 즉, userRepository 얘도 메모리에 같이 올라간다는 뜻
	// @Autowired는 스프링이 관리하는 UserRepository 타입의 객체가 있으면 userRepository 여기에 넣어준다
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository; // 여기서 레파지토리 연결
	
	// update
	// http://localhost:8000/blog/dummy/user/1
	// save 함수는 id를 전달하지 않으면 insert를 해주고
	// save 함수는 id를 전달하면 해당 id에 데이터가 있으면 update 해주고
	// save 함수는 id를 전달하면 해당 id에 데이터가 없으면 insert 한다.
	@Transactional // save 함수 호출 안 해도 함수 종료시에 자동 commit 이 됨. // 더티 체킹
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) { //json 데이터를 요청 => Java Object(MessageConverter의 Jackson라이브러리가 변환해서 받아.)

		// 실제 DB에서 받은 user
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});

		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		return user;
	}
	
	// Delete 테스트
	// http://localhost:8000/blog/dummy/user/1 -> user1을 삭제해보자 
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		return " 삭제되었습니다. id : " + id;
	}
	
	// select - 여러 건
	// 여러 건의 데이터 불러오기
	// http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/users") // 페이징 테스트 하면서 /dummy/user 에서 /dummy/users로 바꿈
	public List<User> list(){
		return userRepository.findAll(); // 전체가 다 리턴됨
	}
	
	// select - 페이징
	// 한페이지당 2건의 데이터를 리턴받기 테스트
	// JSP 같은 것은 페이징 할라면 개발자가 로직을 다 짜야하는데
	// JPA는 페이징하는 강력한 pageable 기능을 제공함 
	// http://localhost:8000/blog/dummy/user?page=0 
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Direction.DESC) Pageable pageable){
		// 2건씩, id로, DESC : id를  최신순으로 들고온다.
		Page<User> pagingUser = userRepository.findAll(pageable);
		List<User> users = pagingUser.getContent();
		return users;
	}

	// select
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// findById의 리턴 타입이 User가 아니라 Optional이다. 
		// 만약에 없는 id를 찾을 때, 데이터베이스에서 못 찾아오니까 user가 null이 된다.
		// 그럼 return 할 때 null이 return된다. 그럼 프로그램에 문제가 생길수도...
		// 그래서 Optional로 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return 하는 것이다
		// http://localhost:8000/blog/dummy/user/3
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다! id : " + id);
			} 	// 뭔말이야;;
		});		
		return user;
	}
	
	// 회원 가입
	// http://localhost:8000/blog/dummy/join
	@PostMapping("/dummy/join")
	public  String join(User user) { 

		user.setRole(RoleType.USER);
		userRepository.save(user); // save로 인해 DB에 저장 됨
		
		return "회원가입이 완료되었습니다.";
	}
}
