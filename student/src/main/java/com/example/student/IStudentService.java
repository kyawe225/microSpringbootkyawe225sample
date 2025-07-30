package com.example.student;

import java.util.List;


public interface IStudentService {
    boolean insert(Student s);
    boolean update(Student s);
    boolean delete(int id);
    Iterable<Student> all();
    Student getDetail(int id);
    boolean saveAll(List<Student> s);
    Iterable<Student> schoolRelatedStudents(int schoolId);
}
