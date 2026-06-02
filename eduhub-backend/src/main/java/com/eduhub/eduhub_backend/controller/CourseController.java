package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import com.eduhub.eduhub_backend.component.CourseServicedemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired //dependency injection
    //instead using autowired we can do dependency injection using contructor that is shown below
//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }
    CourseService courseService;
    @GetMapping("get-course")
    public String getCourse(){
        return courseService.getCourses();
    }
    @Autowired
    CourseServicedemo courseServicedemo;
    @GetMapping("get-details")
    public String getDetails()
    {
        return courseServicedemo.getdetails();
    }
}
