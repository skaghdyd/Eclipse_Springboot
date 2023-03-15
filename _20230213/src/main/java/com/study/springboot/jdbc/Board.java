package com.study.springboot.jdbc;

import lombok.Data;

@Data
public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
}
