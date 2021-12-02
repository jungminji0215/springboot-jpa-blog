package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 메인 페이지 갈 때, 데이터를 가져와야 함 
	// 스프링에서 데이터 가져갈때 Model 필요함
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable)); // 누가 '/' 경로로 요청을 하면 model에 글목록을 다 들고온다.
		 
		// /WEB-INF/views/index.jsp -> 이 경로를 찾아서 넘겨줌 
		return "index"; //컨트롤러는 리턴할 때, viewResolver라는 것이 작동 -> 해당 페이지로(여기서는 index) model의 정보를 들고 이동한다 (boards가 index로 다 넘어감)
		// viewResolver가 index 앞뒤로 경로 붙여서 /WEB-INF/views/index.jsp 이렇게 해줌
		// model은 jsp에서 요청정보라고 생각하자!
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		
		return "board/detail";
	}		
	
	// USER 권한이 필요
		@GetMapping("/board/saveForm")
		public String saveForm() {
			return "board/saveForm";
		}	
		
		@GetMapping("/board/{id}/updateForm")
		public String updateForm(@PathVariable int id, Model model) { // model은 해당 데이터를 가지고 view까지 이동한다.
			model.addAttribute("board", boardService.글상세보기(id));
			return "board/updateForm";
			
		}
}
