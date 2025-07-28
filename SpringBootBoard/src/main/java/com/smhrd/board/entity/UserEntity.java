package com.smhrd.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // table 생성
@Data // getter + setter
// 이미 만들어 놓은 DB 사용하고 싶을 때/ DB 이름을 다르게 지정하고 싶을 때
// 주의 사항 : 컬럼이 다르다, 포렌키 삭제 불가 등 문제 발생 > 새로 테이블 만드는 걸 권장
@Table(name = "user")
public class UserEntity {
	
	// pk 값이 필수
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increase
	private Long idx; // 객체타입으로 삽입 > DB에 해당 값이 없으면 null로 값이 넘어옵니다
	
	@Column(nullable = false, unique = true)
	private String id;
	private String pw;
	private String name;
	private Integer age; // 설계할때 null이 가능하다면 Integer을 사용
	
}
