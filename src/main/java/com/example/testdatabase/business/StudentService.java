package com.example.testdatabase.business;

import com.example.testdatabase.ResourceNotFoundException;
import com.example.testdatabase.model.Student;
import com.example.testdatabase.repository.SchoolRepository;
import com.example.testdatabase.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String stuID) {
        return studentRepository.findByStuID(stuID);
    }

    public Student insertStudent(Student student, Long schoolId) {
        return schoolRepository.findById(schoolId).map(sch -> {
            student.setSchool(sch);
            return studentRepository.save(student);
        }).orElseThrow(() -> new ResourceNotFoundException("SchoolId " + schoolId + " not found"));
    }

    public String deleteStudentById(String stuID) {
        studentRepository.deleteByStuID(stuID);
        return "delete successful";
    }

    public Student updateStudent(Student student) {
        return studentRepository.findByStuID(student.getStuID())
                .map(std -> {
                    std.setName(student.getName());
                    std.setAge(student.getAge());
                    return studentRepository.save(std);
                }).orElseThrow(() -> new ResourceNotFoundException("Student not found with stuId " + student.getStuID()));

/*
        studentRepository.findAll()
                .parallelStream()
                .filter(a -> a.getStuID().equals("123"))
                .findAny()
                .collect(Collectors.toList())

 */
    }


}
