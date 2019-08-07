package com.example.demo;

import com.example.demo.ServiceHandlers.CourseServiceHandler;
import com.example.demo.ServiceHandlers.UniversityServiceHandler;
import com.example.demo.thrift.gen.CourseService;
import com.example.demo.thrift.gen.UniversityService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;

@SpringBootApplication
@EntityScan
@EnableMongoAuditing
public class UniversityCoursesapiApplication {

	@Autowired
	private CourseServiceHandler courseServiceHandler;

	@Autowired
	private UniversityServiceHandler universityServiceHandler;

	public static void main(String[] args) {
		SpringApplication.run(UniversityCoursesapiApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean CourseServlet() {
		TProcessor processor = new CourseService.Processor<>(courseServiceHandler);
		TProtocolFactory factory = new TJSONProtocol.Factory();
		Servlet courseServlet = new TServlet(processor, factory);
		ServletRegistrationBean servlet = new ServletRegistrationBean(courseServlet, "/courses/");
		servlet.setName("courseServlet");
		return servlet;
	}

	@Bean
	public  ServletRegistrationBean UniversityServlet(){
		TProcessor tProcessor=new UniversityService.Processor<>(universityServiceHandler);
		TProtocolFactory tProtocolFactory=new TJSONProtocol.Factory();
		Servlet universityServlet=new TServlet(tProcessor,tProtocolFactory);
		ServletRegistrationBean servlet= new ServletRegistrationBean(universityServlet,"/universities/");
		servlet.setName("universityServlet");
		return servlet;
	}




}
