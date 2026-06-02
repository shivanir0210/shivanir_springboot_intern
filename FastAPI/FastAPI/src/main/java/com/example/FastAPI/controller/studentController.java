package com.example.FastAPI.controller;

import com.example.FastAPI.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {
    private String id;
    private String name;
    private String age;

    public studentController() {
    }

    public studentController(String id, String name, String age, studentService s) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.s = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public studentService getS() {
        return s;
    }

    public void setS(studentService s) {
        this.s = s;
    }


    @Autowired
    studentService s;

}
