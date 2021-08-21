package dev.patika.gittigidiyorhomework02.controller;

import dev.patika.gittigidiyorhomework02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
}



