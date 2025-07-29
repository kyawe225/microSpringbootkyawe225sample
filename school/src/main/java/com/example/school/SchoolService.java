package com.example.school;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {

    @Autowired
    SchoolRepository repository;
    Logger logger = LoggerFactory.getLogger(SchoolService.class);


    @Override
    public boolean insert(School s) {
        try {
            School j = repository.save(s);
            return j == null ? false : true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean update(School s) {
        try {
            School j = repository.save(s);
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
            School school = repository.findById(s).get();
            if (school == null) {
                return false;
            }
            repository.delete(school);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<School> all() {
        return repository.findAll();
    }

    @Override
    public School getDetail(int s) {
        try {
            School school = repository.findById(s).get();
            return school;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public boolean saveAll(List<School> s){
        try {
            Iterable<School> j = repository.saveAll(s);
            return j.iterator().hasNext();
        } catch (Exception e) {
            return false;
        }
    }
    // just add crud code ....... and fuck those shits

}
