package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
