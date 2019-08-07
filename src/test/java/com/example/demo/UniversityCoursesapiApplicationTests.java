package com.example.demo;

import com.example.demo.thrift.gen.UniversityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityCoursesapiApplicationTests {

	@Test
	public void contextLoads() {
		UniversityService.Client client;
	}

}
