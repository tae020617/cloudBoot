package com.smhrd.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.service.BoardService;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
    @GetMapping("/")
    public String index(Model model) {
    	// board service 연결
    	// board service - repository 연결해서 가지고오기
    	// board repository - findAll() -- 새롭게 메소지 만들 필요가 없다.
    	// ArrayList에 담은 후
    	// scope 처리 model 객체에 담아주세요 => boardList
    	ArrayList<BoardEntity> list =  boardService.selectAll();
    	model.addAttribute("boardList", list);
        return "index";
    }
	
//    @GetMapping("/")
//    public String index(Model model) {
//        List<BoardEntity> boardList = boardService.getAllBoards();
//        model.addAttribute("boardList", boardList);
//        return "index";
//    }
    
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
