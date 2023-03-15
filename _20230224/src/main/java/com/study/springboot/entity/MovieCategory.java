package com.study.springboot.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class MovieCategory {
	
	@Id
	@Column(name = "movieCategory_type")
	private Integer type; //영화종류
	
	private String name;
}
