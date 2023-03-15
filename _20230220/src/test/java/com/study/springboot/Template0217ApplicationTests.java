package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Movie;
import com.study.springboot.entity.Poster;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MovieRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;

	@Autowired
	MovieRepository movieRepository;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
	public void testMyBatisFindAllEmp() {
		List<Emp> list 
		= empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}
	
//	@Test
	public void testFindAllEmp() {
		//List<Emp> list = empRepository.findAll();
		//log.info(list);
	}
	
	@Test
	public void testInsMovie() {
//		Movie movie = Movie.builder()
//				.title("테스트 영화1")
//				.build();
//		log.info(movie);
		
		Movie movie = new Movie();
		movie.setTitle("영화1");
		log.info(movie);
		
		Poster poster = Poster.builder()
				.idx(movie.getPosterList().size())
				.name("영화1 포스터1")
				.movie(movie)
				.build();
		log.info(poster);
		movie.getPosterList().add(poster);
		
		Poster poster2 = Poster.builder()
				.idx(movie.getPosterList().size())
				.name("영화1 포스터2")
				.movie(movie)
				.build();
		log.info(poster2);
		movie.getPosterList().add(poster2);
		
		log.info(movieRepository.save(movie));
	}

}
