package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
		log.info("-----------테스트 시작------------");
	}
	
	@Test
	void testFindAll() {
		List<Board> list = boardMapper.findAll("길");
		for(Board board : list) {
			log.info(board);
		}
	}
}