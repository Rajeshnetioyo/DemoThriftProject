package com.example.demo.Dbseeders;

import com.example.demo.Models.Course;
import com.example.demo.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder_Course implements CommandLineRunner {

    @Autowired
    private CourseRepository cr;

    @Override
    public void run(String... args) throws Exception {
        Course c1=new Course("Physics");
        Course c2=new Course("Chemistry");
        Course c3=new Course("Biology");
        cr.deleteAll();
        cr.saveAll(Arrays.asList(c1,c2,c3));
    }
}
