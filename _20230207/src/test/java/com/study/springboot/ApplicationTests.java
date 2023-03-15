package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.dao.Emp;
import com.study.springboot.dao.EmpMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	EmpMapper empMapper;
	
	@Autowired
	public ApplicationTests(EmpMapper empMapper) {
		super();
		this.empMapper = empMapper;
	}
	
	@Test
	void contextLoads() {
	}
	@Test
	void test() {
		log.info("*****로그 테스트***********");
		assertThat("aaa").isEqualTo("aaa");
		Emp emp = empMapper.selectOne(7369);
		log.info(emp);
//		List<Emp> list = empMapper.findAll();
//		log.info(list);
	}
	
}
