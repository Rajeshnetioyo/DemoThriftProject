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
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository ur;

    public List<UniversityThrift> getAllUniversities(){
        List<UniversityThrift> UniversityThrifts=new ArrayList<>();
        List<University> Universities=new ArrayList<>();
        Universities.addAll(ur.findAll());
        for(University u:Universities){
            List<CourseThrift> courseThrifts=new ArrayList<>();
            if(Objects.nonNull(u.getCourses())){
                for(Course course:u.getCourses()){
                    courseThrifts.add(new CourseThrift(course.getId(),course.getName(),course.isOffered()));
                }
            }
            UniversityThrift universityThrift=new UniversityThrift(u.getId(),u.getUniv_name(),courseThrifts);
            UniversityThrifts.add(universityThrift);

        }
        return UniversityThrifts;

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
