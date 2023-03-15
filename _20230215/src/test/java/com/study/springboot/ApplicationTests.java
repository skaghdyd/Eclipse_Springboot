package com.study.springboot;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.MyData;
import com.study.springboot.repository.MyDataRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	@Autowired
	MyDataRepository myDataRepository;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
	public void insertTest() {
		IntStream.rangeClosed(1, 10).forEach(e->{
			MyData myData = MyData.builder()
					.memo("테스트" + e).build();
			log.info(myData);
			myDataRepository.save(myData);
		});		
//		MyData myData = new MyData();
	}
	
//	@Test
	public void selectAllTest() {
		List<MyData> list = myDataRepository.findAll();
//		for(MyData myData : list) {
//			log.info(myData);
//		}
		
		list.stream().forEach(e->{
			log.info(e);
		});
	}
	
//	@Test
	public void updateTest() {
		MyData myData = MyData.builder()
				.id(12L)
				.memo("업데이트테스트")
				.build();
		log.info(myDataRepository.save(myData));
	}
	
//	@Test
	public void deleteTest() {
		myDataRepository.deleteById(10L);
	}
	
	@Test
	public void selectOneTest() {
		MyData none = MyData.builder()
				.memo("없음").build();
		Optional<MyData> myData = myDataRepository.findById(10L);
		log.info(myData.orElse(none));
		
	}
}
