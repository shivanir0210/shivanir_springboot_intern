package com.example.dataJPA.Controller;

import com.example.dataJPA.Model.Student;
import com.example.dataJPA.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("/students")
    public List<Student> getAllstudents()
    {
        return s.getAllstudents();
    }
}
