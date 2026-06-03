package com.example.dataJPA.Controller;

import com.example.dataJPA.Model.Student;
import com.example.dataJPA.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("/students/get")
    public List<Student> getAllstudents()
    {
        return s.getAllstudents();
    }
    @PostMapping("/students/post")
    public String addstudent(@RequestBody Student stu)
    {
      s.addstudentin(stu);
        return "sucess";
    }
    @GetMapping("/students/get/{id}")
    public Student getstudentsbuid(@PathVariable int id)
    {
        return s.getstudentin(id);
    }

    @PutMapping("/students/put")
    public String updatestudentin(@RequestBody Student stu)
    {
        s.updatestudentin(stu);
        return "sucess";
    }

    @DeleteMapping("/students/delete/{id}")
    public String deletestudnet(@PathVariable int id)
    {
        s.deletestudent(id);
        return "deleted sucessfully";
    }
    @DeleteMapping("studnets/deleteall")
    public String deleteallstudent()
    {
        s.deletedstudentall();
        return "deleted sucessfull";
    }

    @GetMapping("/custom")
    public List<Student> getbygenderantech(@RequestParam("tech") String tech,@RequestParam("gender") String gender)
    {
        return s.getByGenTech(tech,gender);
    }

    @GetMapping("/students/{tech}")
    public List<Student> getstudentbytech(@PathVariable("tech") String tech)
    {
        return s.getStudentByTech(tech);
    }

    //Native query
    @PostMapping("/students/filter")
    public List<Student> getstudentbygenandtech(@Param("gender")String gender,@Param("tech")String tech)
    {
        return s.getstudentbyfilter(gender,tech);
    }

    //JPQL -->Java Persistance Query Language
    @PostMapping("/students/byjpql")
    public List<Student>getstudentbyjpql(@Param("name") String name)
    {
        return s.getstudentbyjpql(name);
    }

}

//Native query --> in tables rows and columns
//JPQL query --> working in entity using field