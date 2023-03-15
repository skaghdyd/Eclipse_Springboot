package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.springboot.entity.Movie;
import com.study.springboot.entity.MovieCategory;
import com.study.springboot.entity.MoviePK;
import com.study.springboot.repository.MovieCategoryReository;
import com.study.springboot.repository.MovieRepository;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	MovieCategoryReository movieCategoryReository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		List<MovieCategory> list = movieCategoryReository.findAll();
		log.info(list);
		model.addAttribute("list",list);
		return "view/index";
	}
	
	@GetMapping("/insertMovieCategory")
	public String insertMovieCategory(Model model) {
		List<MovieCategory> list = movieCategoryReository.findAll();
		log.info(list);
		model.addAttribute("list",list);
		return "view/insertMovieCategory";
	}
	
	@PostMapping("/insertMovieCategory")
	public String insertMovieCategory(MovieCategory movieCategory) {
		log.info(movieCategory);
		movieCategoryReository.save(movieCategory);
		List<MovieCategory> list = movieCategoryReository.findAll();
		log.info(list);
		return "redirect:/";
	}
	
	@GetMapping("/insertMovie")
	public String insertMovie(Model model) {
		List<MovieCategory> list = movieCategoryReository.findAll();
		log.info(list);
		model.addAttribute("list",list);
		return "view/insertMovie";
	}
	
	@PostMapping("/insertMovie")
	public String insertMovie(Movie movie, int type) {
		
		int idx_max = movieRepository.findMaxIdxByType(type);
		MoviePK moviePK = new MoviePK();
		moviePK.setType(type);
		moviePK.setIdx(idx_max);
		movie.setMoviePK(moviePK);
		MovieCategory movieCategory = movieCategoryReository.findById(type).orElseThrow();
		movie.setMovieCategory(movieCategory);
		log.info(movie);
		movieRepository.save(movie);
		
		List<Movie> list = movieRepository.findAll();
		log.info(list);
		
		return "redirect:/";
	}
}
