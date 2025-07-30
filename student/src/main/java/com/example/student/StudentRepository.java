package com.example.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    Iterable<Student> findBySchoolId(int SchoolId);
}
