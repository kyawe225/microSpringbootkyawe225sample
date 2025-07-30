package com.example.student;

import java.util.List;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository repository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);


    @Override
    public boolean insert(Student s) {
        try {
            Student j = repository.save(s);
            return j == null ? false : true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean update(Student s) {
        try {
            Student j = repository.save(s);
            return j == null ? false : true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }
    @Transactional()
    @Override
    public boolean delete(int s) {
        try {
            Student student = repository.findById(s).get();
            if (student == null) {
                return false;
            }
            repository.delete(student);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<Student> all() {
        return repository.findAll();
    }

    @Override
    public Student getDetail(int s) {
        try {
            Student student = repository.findById(s).get();
            return student;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public boolean saveAll(List<Student> s){
        try {
            Iterable<Student> j = repository.saveAll(s);
            return j.iterator().hasNext();
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<Student> schoolRelatedStudents(int schoolId) {
        return repository.findBySchoolId(schoolId);
    }
    // just add crud code ....... and fuck those shits

}
