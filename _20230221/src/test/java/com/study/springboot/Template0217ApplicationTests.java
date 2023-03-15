package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Master;
import com.study.springboot.entity.Slave;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MasterRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	MasterRepository masterRepository;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
	public void testMyBatisFindAllEmp() {
		List<Emp> list 
		= empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}
	
//	@Test
	public void testFindAllEmp() {
		//List<Emp> list = empRepository.findAll();
		//log.info(list);
	}

//	@Test
	public void insertMasterSlave() {
		Master master = new Master();
		master.setCode("30");
		master.setComment("마스터1");
		master.addSlave(
				Slave.builder()
				.title("노예1")
				.content("내용1")
				.build()
				);
		master.addSlave(
				Slave.builder()
				.title("노예2")
				.content("내용2")
				.build()
				);
		masterRepository.save(master);
		log.info(master);
	}
	
	@Test
	public void selectMasterSlave() {
		Master master = masterRepository
				.findById(3L).orElseThrow();
		List<Slave> slaveList = master.getSlaveList();
		log.info(slaveList);
	}
}
