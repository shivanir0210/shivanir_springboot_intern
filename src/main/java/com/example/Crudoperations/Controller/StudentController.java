package com.example.Crudoperations.Controller;

import com.example.Crudoperations.Service.StudentService;
import com.example.Crudoperations.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("/students")
    public List<Student> getAllstudents()
    {
        return s.getstudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentsbyid(@PathVariable("id") int id)
    {
        return s.getStudentsbyid(id);
    }

    @PostMapping("/students/post")
    public String addStudents(@RequestBody Student  stud)
    {
        s.addstudent(stud);
        return "sucess";


    }
    @PutMapping("/students/update/{id}")
    public String updatestudent(@PathVariable int id,
                                @RequestBody Student stud)
    {
        return s.updatestidentbyid(id, stud);
    }
    @DeleteMapping("/delete/{id}")
    public String deletestudents(@PathVariable int id)
    {
        return s.deletestudents(id);
    }
}
