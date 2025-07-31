package com.smhrd.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.board.config.FileUploadConfig;
import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.service.BoardService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class BoardRestController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	FileUploadConfig fileUploadConfig;
	
	@DeleteMapping("/delete/{id}")
	public void delteBoard(@PathVariable Long id) {
		// 1. 필요한 것 id
		
		// 2. service 연결
		String imgPath = boardService.detailPage(id).get().getImgPath();
		String uploadDir = fileUploadConfig.getUploadDir();
		if(imgPath != null && !imgPath.isEmpty()) {
			// 경로 접근
			// imgPath -> ~~~
			Path filePath = Paths.get(uploadDir, imgPath.replace("/uploads/", ""));
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// DB에 삭제는 완료
		boardService.deleteBoard(id);
	}
	
	// 검색기능
	@GetMapping("/search")
	public List<BoardEntity> search(@RequestParam String type, @RequestParam String keyword) {
		// 1. 필요한거 -- type, keyword
		// 2. service 연결
		return boardService.searchResult(type, keyword);
	}
}
