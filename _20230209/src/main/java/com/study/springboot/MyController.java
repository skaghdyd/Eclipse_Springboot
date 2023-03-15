package com.study.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/ex")
public class MyController {
	
	private final EmpDao empDao;
	
	@GetMapping("/ex1")
	public void ex1() {
		log.info("/ex1...................................");
	}
	@GetMapping("/ex2")
	public void ex2(Model model) {
		log.info("/ex2...................................");
		List<String> strList = IntStream.range(1, 10)
				.mapToObj(i->"Data"+i)
				.collect(Collectors.toList());
		log.info("---------------------"+strList);
		model.addAttribute("list", strList);
		
		Map<String,String> map = new HashMap<>();
		map.put("A", "AAA");
		map.put("B", "BBB");
		map.put("C", "CCC");
		model.addAttribute("map", map);		
	}
	
	@GetMapping("/ex3")
	public void ex3() {
		log.info("/ex3...................................");
	}
	
	@PostMapping("/ex3")
	public String ex3(Emp emp) {
		int res = empDao.write(emp);
		log.info("........................"+res);
		return "redirect:/ex/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Emp> elst = empDao.list();
		model.addAttribute("list", elst);
	}
	
	@GetMapping("/update")
	public void update(int empno, Model model) {
		Emp emp = empDao.viewOne(empno);
		model.addAttribute("emp", emp);
	}
	
	@PostMapping("/update")
	public String update(Emp emp) {
		empDao.update(emp);
		return "redirect:/ex/list";
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		model.addAttribute("arr", 
				new String[] {
						"A1",
						"B1",
						"C1",
						"D1",
						"E1"
						}
		);
	}
}
