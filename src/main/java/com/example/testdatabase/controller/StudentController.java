package com.example.testdatabase.controller;


import com.example.testdatabase.business.StudentService;
import com.example.testdatabase.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, value="/student")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value="/student/{stuID}")
    @ResponseBody
    public Optional<Student> getStudentById(@PathVariable("stuID") String stuID) {
        return studentService.getStudentById(stuID);
    }

    @RequestMapping(method = RequestMethod.POST, value="/student/{schoolId}")
    @ResponseBody
    public Student insertStudent(@RequestBody Student student,
                                 @PathVariable (value = "schoolId") Long schoolId) {
        return studentService.insertStudent(student, schoolId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/student/{stuID}")
    @ResponseBody
    public String deleteStudentById(@PathVariable("stuID") String stuID) {
        return studentService.deleteStudentById(stuID);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/student")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
