package com.example.demo.Models;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course")
public class Course {
    private String id;
    @Indexed(name="name",direction = IndexDirection.ASCENDING)
    private  String name;
    private boolean offered;

    public Course(String name) {
        this.name = name;
        this.offered=true;
}

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.offered=true;
    }

    public Course(String id, String name, boolean offered) {
        this.id = id;
        this.name = name;
        this.offered = offered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }
}
