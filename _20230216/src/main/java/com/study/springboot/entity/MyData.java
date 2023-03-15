package com.study.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="mydata")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 200, nullable = true)
	private String email;
	
	private Integer age;
	
	@Column(nullable = true)
	private String memo;
}
