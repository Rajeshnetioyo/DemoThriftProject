package com.example.demo.ServiceHandlers;

import com.example.demo.Models.Course;
import com.example.demo.thrift.gen.CourseService;
import com.example.demo.thrift.gen.CourseThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseServiceHandler implements CourseService.Iface {

    @Autowired
    private com.example.demo.Services.CourseService cs;
    @Override
    public boolean ping() throws TException {
        return true;
    }

    @Override
    public List<CourseThrift> getAllCourses() throws TException {
        return cs.getAll_Courses();
    }

    @Override
    public void delCourse(String id) throws TException {
        cs.del_Course(id);
    }

    @Override
    public void updateCourse(CourseThrift ct) throws TException {
        Course c=new Course(ct.getId(),ct.getName(),ct.isSetId());
        cs.upd_Course(c);
    }

    @Override
    public void addCourse(String name) throws TException {

        cs.add_Course(new Course(name));
    }
}
