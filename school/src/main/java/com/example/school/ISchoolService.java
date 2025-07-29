package com.example.school;

import java.util.List;


public interface ISchoolService {
    boolean insert(School s);
    boolean update(School s);
    boolean delete(int id);
    Iterable<School> all();
    School getDetail(int id);
    boolean saveAll(List<School> s);
}
