package com.smhrd.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.board.entity.UserEntity;
//ctrl + shift + F : 코드 자동 정렬

//1. annotation 달아주기
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// 3. JpaRepository 인터페이스 상속
	// - T : entity
	// - ID : entity의 pk값의 자료형, 레퍼런스타입 넣어야함 > 시험 출제
	// 2. entity 구성

	// exists() > 데이터의 존재 여부 판단 > true/false
	// 커스텀 응용 existsBy컬럼명
	boolean existsById(String id);

	// 로그인 기능
	UserEntity findAllByIdAndPw (String id, String pw);
}