package com.study.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "master")
@Entity
public class Slave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	
	private String title;
	private String content;
	private int idx; //순번
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Master master;
}
