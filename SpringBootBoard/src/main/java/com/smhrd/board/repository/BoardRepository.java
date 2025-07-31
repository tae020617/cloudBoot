package com.smhrd.board.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smhrd.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
	// 게시글이 역순으로 출력될 수 있는 기능
	ArrayList<BoardEntity> findAllByOrderByIdDesc();
	
	// like문을 사용해서 title을 가지고오는 메서드
	// containing -> like문(매개변수 안의 값을 바탕으로)
	List<BoardEntity> findByTitleContaining(String keyword);
	
	// 내가 원하는 쿼리문 바로 실행 -> @Query
	// like문 사용하여 content 가지고 오는 메소드
	@Query("SELECT b FROM BoardEntity b WHERE b.content LIKE %:keyword%")
	List<BoardEntity> searchContent(@Param("keyword") String keyword);
}
