package com.study.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.dao.EmpMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	//@Autowired
	EmpMapper empMapper;
	
	@Autowired
	public void setEmpMapper(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@GetMapping("/")
	public String root(HttpServletRequest req) {
		log.info("---------test");
		ServletContext sc = req.getServletContext();
		log.info("==========>>>>> " + sc.getAttribute("appName"));
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		List<String> list = Arrays.asList("AAA","BBB","CCC","DDD");
		model.addAttribute("msg","안녕");
		model.addAttribute("list",list);
		return "hello";
	}
}
