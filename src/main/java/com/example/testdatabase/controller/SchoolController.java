package com.example.testdatabase.controller;

import com.example.testdatabase.business.SchoolService;
import com.example.testdatabase.model.School;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/school")
    @ResponseBody
    public List<School> getAllSchools(){
        return schoolService.getSchools();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/school")
    @ResponseBody
    public School createSchool(@RequestBody School school){
        return schoolService.insertSchool(school);
    }
}
