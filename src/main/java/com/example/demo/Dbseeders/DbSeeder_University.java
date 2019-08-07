package com.example.demo.Dbseeders;

import com.example.demo.Models.University;
import com.example.demo.Repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder_University implements CommandLineRunner {

    @Autowired
    private UniversityRepository ur;

    @Override
    public void run(String... args) throws Exception {
        University u1=new University("IITH");
        University u2=new University("IITD");
        University u3=new University("IITKGP");
        ur.deleteAll();
        ur.save(u1);
        ur.save(u2);
        ur.save(u3);
    }
}
