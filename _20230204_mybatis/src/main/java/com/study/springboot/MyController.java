package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	@Autowired
	private EmpMapper empMapper;
	
	@GetMapping("/root")
	public String root() {
		return "root";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> elst = empMapper.findAll();
		model.addAttribute("list", elst);
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp) {
		int res = empMapper.save(emp);
		return "redirect:/list";		
	}
	
	@GetMapping("/delete")
	public String delete(int empno) {
		empMapper.delete(empno);
		return "redirect:/list";
	}
}