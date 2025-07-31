package com.smhrd.board.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increase
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String writer;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	
	private String imgPath; // 이미지 저장 db에 이미지 저장 X 서버에 이미지 저장하고 서버 경로를 DB에 저장
	
	// 현재 날자 (글 작성 일시)
	@Column(nullable=false, updatable = false)
	private LocalDate writeDay;
	
	// JPA 글 작성시 자동으로 오늘 날짜 입력할 수 있게 하는 코드
	@PrePersist
	protected void onWriteDay() {
		this.writeDay = LocalDate.now();
	}
}