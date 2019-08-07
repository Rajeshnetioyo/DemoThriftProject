package com.example.demo.ServiceHandlers;

import com.example.demo.Models.Course;
import com.example.demo.Models.University;
import com.example.demo.thrift.gen.CourseThrift;
import com.example.demo.thrift.gen.UniversityService;
import com.example.demo.thrift.gen.UniversityThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UniversityServiceHandler implements UniversityService.Iface {

    @Autowired
    private com.example.demo.Services.UniversityService us;

    @Override
    public boolean ping() throws TException {
        return true;
    }

    @Override
    public List<UniversityThrift> getAllUniversities() throws TException {
        return us.getAllUniversities();
    }

    @Override
    public void addUniversity(String name) throws TException {

        us.add_University(new University(name));
    }

    @Override
    public void updUniversity(UniversityThrift ut) throws TException {
        University u = new University();
        u.setId(ut.getId());
        u.setUniv_name(ut.getUniv_name());
        List<Course> cs = new ArrayList<>();
        List<CourseThrift> cts = ut.getCourses();
        for (CourseThrift ct : cts) {
            cs.add(new Course(ct.getId(), ct.getName(), ct.isSetApproved()));
        }
        u.setCourses(cs);
        us.upd_University(u);
    }

    @Override
    public void delUniversity(String id) throws TException {
        us.del_University(id);
    }
}
