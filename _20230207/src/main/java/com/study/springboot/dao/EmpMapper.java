package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {
	@Select("select * from emp_temp")
	List<Emp> findAll();
	
	@Select("select * from emp_temp where empno=#{empno}")
	Emp selectOne(int empno);
	
	@Update("update emp_temp "
			+ "set ename = #{ename}, "
			+ "job=#{job}, sal=#{sal}, "
			+ "empno=#{empno} "
			+ "where empno=#{empno}")
	int update(Emp emp);
}
