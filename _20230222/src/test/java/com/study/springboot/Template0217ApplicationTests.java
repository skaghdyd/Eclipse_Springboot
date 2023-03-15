package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Product;
import com.study.springboot.entity.ProductDetail;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.ProductDetailRepository;
import com.study.springboot.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;
	
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
	public void testInsProduct() {
		Product product = Product.builder()
								.name("상품1")
								.price(30000)
								.stock(10)
								.build();
		ProductDetail pd = ProductDetail.builder()
										.content("상품1_디테일1")
										.build();
		
		pd.setProduct(product);
		product.setProductDetail(pd);
		productRepository.save(product);
		
//		pd.setProduct(product);
//		productDetailRepository.save(pd);
	}
	
	@Test
	public void testSelectProduct() {
		Product product = productRepository.findById(1L).orElseThrow();
		log.info(product);
		log.info(product.getProductDetail());
	}
}
