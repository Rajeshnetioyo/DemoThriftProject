package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {
    public void deleteById(String id);
}
