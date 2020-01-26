package com.example.testdatabase;

import com.example.testdatabase.model.School;
import com.example.testdatabase.model.Student;
import com.example.testdatabase.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Test implements CommandLineRunner {


    private final StudentRepository studentRepository;

    public Test(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        HashMap<Long, List<Student>> hmap = new HashMap<Long, List<Student>>();
        Map<School,List<Student>> collect = studentRepository.findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(Student::getSchool));
        System.out.println(collect);

        List<Student> students = studentRepository.findAll();
        for (Student stu:students) {
            List<Student> stulist = hmap.get(stu.getSchool().getId());
            if(stulist == null)
                stulist = new ArrayList<>();
            stulist.add(stu);
            hmap.put(stu.getSchool().getId(), stulist);
        }
        System.out.println(hmap);

    }
}
