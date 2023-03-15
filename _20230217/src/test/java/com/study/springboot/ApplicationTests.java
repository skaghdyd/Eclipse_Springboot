package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;	
	
	@Test
	void contextLoads() {
	}
	
//	@Test
	public void testMyBatisFindAllEmp() {
		String search = "78";
		String type = "S";
		List<Emp> list = empDeptMapper.findAllEmp(search, type);
		for(Emp emp : list) {
			log.info(emp);
		}
	}
	
//	@Test
//	public void testFindAllEmp() {
//		List<Emp> list = empRepository.findAll();
//		for(Emp emp : list) {
//			log.info(emp);
//		}
//	}

}
