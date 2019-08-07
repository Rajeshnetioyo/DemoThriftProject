package com.example.demo;
import com.example.demo.thrift.gen.CourseService;
import com.example.demo.thrift.gen.CourseThrift;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseClientTest {
    public CourseService.Client cs;

    @Test
    public  void CoursesTest() throws TException {
        THttpClient tHttpClient=new THttpClient("http://localhost:8080/courses/");
        tHttpClient.setConnectTimeout(3000);
        TProtocol tProtocol=new TJSONProtocol(tHttpClient);
        cs=new CourseService.Client(tProtocol);
        System.out.println(cs.getAllCourses());
        cs.addCourse("MetaPhysics");
        System.out.println("Getting all courses.......");
        System.out.println(cs.getAllCourses());
        CourseThrift ct=new CourseThrift("hjqkjfhkfhk12246871246","Electromagnetism",true);
        cs.updateCourse(ct);
        System.out.println(cs.getAllCourses());
        cs.delCourse("hjqkjfhkfhk12246871246");
        System.out.println(cs.getAllCourses());

    }

}
