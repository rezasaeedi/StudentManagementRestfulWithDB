package com.example.testdatabase.business;

import com.example.testdatabase.ResourceNotFoundException;
import com.example.testdatabase.model.Lesson;
import com.example.testdatabase.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson insertLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public String deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        return "delete successful";
    }

    public Lesson updateLesson(Lesson lesson) {

        return lessonRepository.findById(lesson.getId())
                .map(less -> {
                    less.setName(lesson.getName());
                    less.setUnit(lesson.getUnit());
                    return lessonRepository.save(less);
                }).orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id " + lesson.getId()));
    }
}
