package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	
	final BoardMapper boardMapper;
	
	@GetMapping("/test1")
	public void test1(String writer, Model model, HttpSession session) {
		List<Board> list = boardMapper.findAll(writer);
		model.addAttribute("test1",list);
		session.setAttribute("user", "admin");
	}
	
	@GetMapping("/test2")
	public String test1(Model model, HttpSession session) {
		List<Board> list = boardMapper.findAll();
		model.addAttribute("test1",list);
		String user = (String)session.getAttribute("user");
		log.info(">>>>>>>>>>>>>>>> 사용자 : " + user);
		return "test1";
	}
}
