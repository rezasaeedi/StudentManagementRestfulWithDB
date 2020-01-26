package com.example.testdatabase.business;

import com.example.testdatabase.model.School;
import com.example.testdatabase.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools(){
        return schoolRepository.findAll();
    }

    public School insertSchool(School school){
        return schoolRepository.save(school);
    }
}
