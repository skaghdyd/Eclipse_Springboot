package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	EmpDao empDao;
	
	@Autowired
	public ApplicationTests(EmpDao empDao) {
		super();
		this.empDao = empDao;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("emp_temp SELECT 테스트")
	public void testList() {
		List<Emp> list = empDao.list();
		log.info(list);
	}
	
	//@Test
	@DisplayName("emp_temp INSERT 테스트")
	public void testWrite() {
//		Emp emp = new Emp();
//		emp.setEmpno(1234);
//		emp.setEname("테스트1");
//		emp.setJob("사원");
//		emp.setSal(3500);
		
		Emp emp = Emp.builder()
				.empno(5454)
				.ename("테스트2")
				.job("부장")
				.sal(8000)
				.build();
		
		int result = empDao.write(emp);
		assertThat(result).isEqualTo(1);
		log.info(result);
	}
	
	@Test
	@DisplayName("emp_temp SELECT ONE 테스트")
	public void testView() {
		Emp emp = empDao.viewOne(5454);
		log.info(emp);
	}
}
