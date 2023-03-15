package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> elst = empMapper.findAll();
		for (Emp emp : elst) {
			System.out.println(emp);
		}
		model.addAttribute("list", elst);
		return "list";
	}
	
	@GetMapping("/update")
	public String update(int empno, Model model) {
		Emp emp = empMapper.selectOne(empno);
		model.addAttribute("emp", emp);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(Emp emp, Model model) {
		empMapper.update(emp);		
		return "redirect:/list";
	}
}
