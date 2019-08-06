package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.University;
import com.example.demo.Repositories.UniversityRepository;
import com.example.demo.thrift.gen.CourseThrift;
import com.example.demo.thrift.gen.UniversityThrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository ur;

    public List<UniversityThrift> getAllCourses(){
        List<University> us=new ArrayList<>();
        List<UniversityThrift> uts=new ArrayList<>();
        for(University u:ur.findAll()){
            us.add(u);
        }
        for(University u:us){
            List<Course> cs=u.getCourses();
            List <CourseThrift> cts=new ArrayList<>();
            for(Course c:cs){
                cts.add(new CourseThrift(c.getId(),c.getName(),c.isOffered()));
            }
            uts.add(new UniversityThrift(u.getId(),u.getUniv_name(),cts));
        }
        return uts;
    }
    public  void del_University (String id){
        ur.deleteById(id);
    }
    public void upd_University(University u){
        ur.save(u);
    }
    public void add_University(University u){
        ur.save(u);
    }
}
