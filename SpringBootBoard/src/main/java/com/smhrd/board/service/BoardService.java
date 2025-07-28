package com.smhrd.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	// 게시글 작성 기능
	public BoardEntity write(BoardEntity entity) {
		return boardRepository.save(entity);
	}

	// 게시글 전부 가지고 오기
	public ArrayList<BoardEntity> selectAll() {
		// 게시글이 오래된 순서대로 출력
		// 게시글이 최신순으로 출력하게 만들고 싶습니다
		// sql문적으로 풀어보면 oder by write day desc
		return (ArrayList<BoardEntity>) boardRepository.findAllByOrderByWriteDayDesc();
	}

	// 게시글 상세보기 기능
	public Optional<BoardEntity> detailPage(Long id) {
		// repository 연결 후 코드 실행
		// 내장되어 있는 메소드 사용 할때는 repository 코드 수정 x
		// sql - select * from ~~ where id = ?
		// Optional 객체
		// findById의 return 타입이 Optional

		// null 체크하는 객체
		// BoardEntity가 null일 수도 있어
		// 장점
		// npe 에러 (null pointer exception)
		return boardRepository.findById(id);
	}

	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}

	// 검색 기능
	public List<BoardEntity> searchResult(String type, String keyword) {
		
		List<BoardEntity> list = null;
		// 조건 처리
		switch (type) {
		case "title":
			list = boardRepository.findByTitleContaining(keyword);
			
			break;
		case "content":
			list = boardRepository.searchContent(keyword);
			break;
		case "writer":
			break;
		default:
			break;
		}
		
		return list;
	}
}
