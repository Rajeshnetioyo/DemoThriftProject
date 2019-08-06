package com.example.demo.Repositories;

import com.example.demo.Models.University;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University,String> {
}
