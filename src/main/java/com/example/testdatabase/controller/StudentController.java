package com.example.testdatabase.controller;

import com.example.testdatabase.ResourceNotFoundException;
import com.example.testdatabase.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.testdatabase.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value="/student")
    @ResponseBody
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/student/{stuID}")
    @ResponseBody
    public Optional<Student> getAllStudentById(@PathVariable("stuID") String stuID) {
        return studentRepository.findByStuID(stuID);
    }

    @RequestMapping(method = RequestMethod.POST, value="/student")
    @ResponseBody
    public Student insertStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/student/{stuID}")
    @ResponseBody
    public String deleteStudentById(@PathVariable("stuID") String stuID) {
        studentRepository.deleteByStuID(stuID);
        return "delete successful";
    }

    @RequestMapping(method = RequestMethod.PUT, value="/student")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student) {
        /*
        Student studentOptional = studentRepository.findByStuID(student.getStuID());

        if (studentOptional == null)
            return ResponseEntity.notFound().build();

        //student.setId(id);

        studentRepository.save(student);

        return ResponseEntity.noContent().build();

         */

        return studentRepository.findByStuID(student.getStuID())
                .map(std -> {
                    std.setName(student.getName());
                    std.setAge(student.getAge());
                    return studentRepository.save(std);
                }).orElseThrow(() -> new ResourceNotFoundException("Student not found with stuId " + student.getStuID()));
    }
}
