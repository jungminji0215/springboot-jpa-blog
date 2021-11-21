package com.cos.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

//import com.cos.blog.dto.ReplySaveRequestDto;
//import com.cos.blog.repository.ReplyRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 

	@Column(nullable = false, length = 200)
	private String content;
	
	// 이 답변은 어느 게시글에 있는 답변인지 연관관계를 맺어줘야 한다.
	// Many : Reply , One : Board 여러 개의 답변은 하나의 게시글에 있을 수 있다.
	@ManyToOne 
	@JoinColumn(name="boardId") 
	private Board board;
	
	// 여러개의 답변은 하나의 유저가 쓸 수 있다.
	@ManyToOne 
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private LocalDateTime createDate;
}