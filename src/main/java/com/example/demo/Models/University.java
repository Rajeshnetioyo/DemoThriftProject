package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "University")
public class University {
    @Id
    private String id;
    private  String univ_name;
    private List<Course> courses;

    public University() {
    }

    public University(String univ_name) {
        this.univ_name = univ_name;
        this.courses=new ArrayList<>();
    }

    public University(String id, String univ_name, List<Course> courses) {
        this.id = id;
        this.univ_name = univ_name;
        this.courses = courses;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
