package com.example.demo;


import com.example.demo.Models.Course;
import com.example.demo.thrift.gen.CourseThrift;
import com.example.demo.thrift.gen.UniversityService;
import com.example.demo.thrift.gen.UniversityThrift;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UniversityClientTest {
    private UniversityService.Client us;

    @Test
    public void UniversitiesTest() throws TException {
        THttpClient tHttpClient=new THttpClient("http://localhost:8080/universities/");
        tHttpClient.setConnectTimeout(3000);
        TProtocol tProtocol=new TJSONProtocol(tHttpClient);
        us=new UniversityService.Client(tProtocol);
        us.addUniversity("IITK");
        List <CourseThrift> courses=new ArrayList<>();
        CourseThrift courseThrift=new CourseThrift("101","Astrophysics",true);
        courses.add(courseThrift);
        UniversityThrift ut=new UniversityThrift("1001","VIT",courses);
        us.updUniversity(ut);
        us.delUniversity("1001");

    }

}
