package com.example.testdatabase.controller;

import com.example.testdatabase.model.Lesson;
import org.springframework.web.bind.annotation.*;
import com.example.testdatabase.business.LessonService;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lesson")
    @ResponseBody
    public List<Lesson> getLessons(){
        return lessonService.getLessons();
    }

    @RequestMapping(method = RequestMethod.GET, value="/lesson/{less_id}")
    @ResponseBody
    public Optional<Lesson> getLessonById(@PathVariable("less_id") Long id) {
        return lessonService.getLessonById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/lesson")
    @ResponseBody
    public Lesson insertLesson(@RequestBody Lesson lesson){
        return lessonService.insertLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/lesson/{less_id}")
    @ResponseBody
    public String deleteLessonById(@PathVariable("less_id") Long id) {
        return lessonService.deleteLessonById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/lesson")
    @ResponseBody
    public Lesson updateLessons(@RequestBody Lesson lesson) {

        return lessonService.updateLesson(lesson);
    }
}
