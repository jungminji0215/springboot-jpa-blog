package com.cos.blog.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	
	@Column(nullable = false, length = 100) 
	private String title;
	
	@Lob // 대용량 데이터
	private String content; 
	// 섬머노트 라이브러리 사용할 것 : 사용자가 적는 일반적인 글이 디자인될 때 <html>태그가 섞여서 디자인이 됨.
	// 그러면 용량이 많아짐
	
	// 조회수
	private int count; 
	
	
	// 연관 관계 Many = Board,  User = One -> 한명의 유저는 여러개의 게시글을 쓸 수 있다. ( 여러개의 게시글은 한명의 유저에 의해 쓰일 수 있다.)
	// User 객체니까 User 객체를 참조한다.
	@ManyToOne(fetch = FetchType.EAGER)  
	@JoinColumn(name="userId") //실제 DB에 만들어질때는 userId라는 이름으로 만든다. 라는 의미! User이랑 연관관계가 없으니 
	// 연관관계를 맺어줘야함 : @ManyToOne 사용
	private User user; 
	// DB는 오브젝트를 저장할 수 없다. 그래서 FK 사용하는데, 자바는 오브젝트를 저장할 수 있다.  그럼 FK 사용 안해도 됨
	// ORM 사용하면 객체 저장가능. 즉,  User user 가능
	
	
	
	// 하나의 게시글은 여러 개의 답변을 가질 수 있다. One : Board, Many : Reply
	// @JoinColumn이 필요 없다.
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
    //	@JsonIgnoreProperties({"board"})
    //	@OrderBy("id desc")
	private List<Reply> reply; //한 건이 아니니까 리스트로 
	
	
	
	@CreationTimestamp
	private LocalDateTime createDate; //데이터가 삽입, 수정될 때 자동으로 
}