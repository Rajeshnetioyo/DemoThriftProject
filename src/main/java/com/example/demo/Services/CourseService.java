package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.thrift.gen.CourseThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository cr;

    public List<CourseThrift> getAll_Courses() throws TException {
        List<CourseThrift> cts=new ArrayList<>();
        List<Course> cs=new ArrayList<>();
        for(Course c:cr.findAll()){
            cs.add(c);
        }
        for(Course c:cs){
            CourseThrift ct=new CourseThrift(c.getId(),c.getName(),c.isOffered());
            cts.add(ct);
        }
        return cts;
    }
    public void del_Course(String id){
        cr.deleteById(id);
    }
    public void upd_Course(Course course){
        cr.save(course);
    }
    public void add_Course(Course course){
        cr.save(course);
    }

}
