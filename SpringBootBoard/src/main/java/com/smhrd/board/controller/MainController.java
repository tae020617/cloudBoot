package com.smhrd.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.service.BoardService;

@Controller // Controller class에 달아야함
public class MainController {

    private final UserController userController;
	
	@Autowired
	BoardService bordService;

    MainController(UserController userController) {
        this.userController = userController;
    }
	
	// 1. 매핑
	@GetMapping("/")
	public String index(Model model) {
		// board service 연결 > Autowired 코드
		
		// BoardService.java에 코드 작성
		// board service - repository 연결해서 데이터 가져오기
		// board repository - findAll() > 새롭게 메소드 만들 필요 x
		// ArrayList에 담은 후
		
		// model 객체에 담아주세요 > boardList
		ArrayList<BoardEntity> list = bordService.selectAll();
		model.addAttribute("boardList", list);
		return "index"; // index.html // view에 .html 추가하는 코드 있음
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
}
