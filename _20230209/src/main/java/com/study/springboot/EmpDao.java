package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpDao {
	@Insert("INSERT INTO emp_temp(empno, ename, job, sal)"
			+ " VALUES(#{empno}, #{ename}, #{job}, #{sal})")
    int save(Emp emp);
	
    @Delete("delete from emp_temp where empno = #{empno}")
    int delete(int empno);

	public List<Emp> list();
	public int write(Emp emp);
	public Emp viewOne(int empno);
	int update(Emp emp);
}
