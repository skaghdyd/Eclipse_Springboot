package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {
	@Select("select * from emp_temp")
	List<Emp> findAll();
	
	@Insert("insert into emp_temp(empno, ename, job, sal)"
			+ "values(#{empno}, #{ename}, #{job}, #{sal}")
	int save(Emp emp);
	
	@Delete("delete from emp_temp where empno = #{empno}")
	int delete(int empno);
	
	@Update("update emp_temp set ename = #{ename}, job = #{job}, sal=#{sal} where empno=#{empno}")
	int update(Emp emp);
	
	@Select("select * from emp_temp where empno=#{empno}")
	List<Emp> find(int empno);
	
}
