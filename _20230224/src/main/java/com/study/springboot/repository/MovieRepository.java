package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Movie;
import com.study.springboot.entity.MoviePK;

@Repository
public interface MovieRepository 
	extends JpaRepository<Movie, MoviePK>{

	@Query(value="SELECT ifnull(MAX(idx),0)+1 AS idx_max\r\n"
			+ "FROM movie\r\n"
			+ "WHERE movie_category_type = :type", nativeQuery = true)
	public int findMaxIdxByType(@Param("type") int type);
}