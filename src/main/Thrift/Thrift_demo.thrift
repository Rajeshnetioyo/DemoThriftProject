namespace java com.example.demo.thrift.gen

struct CourseThrift{
    1:string id;
    2:string name;
    3:bool approved;
}
typedef CourseThrift  course

struct UniversityThrift{
    1:string id;
    2:string univ_name;
    3:list<course> courses;
}

service UniversityService{
    bool ping(),
    list<UniversityThrift> getAllUniversities(),
    void delUniversity(1:string id),
    void updUniversity(1: UniversityThrift university),
    void addUniversity(1:string name);
}

service CourseService{
    bool ping(),
    list<CourseThrift> getAllCourses(),
    void delCourse(1:string id),
    void updateCourse(1:CourseThrift ct),
    void addCourse(1:string name);
}
