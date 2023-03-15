package com.study.springboot;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;	
}
