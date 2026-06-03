package com.example.dataJPA.Service;

import com.example.dataJPA.Model.Student;
import com.example.dataJPA.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentService {
    @Autowired
    Repo r;
    public List<Student> getAllstudents() {
        return r.findAll();
    }



    public void addstudentin(Student stu) {
        r.save(stu);

    }

    public Student getstudentin(int id) {

        return r.findById(id).orElse(new Student());
    }
    //save perform if the database does not have the content it will add and if
    // it is there it will update the data
    public Student updatestudentin(Student stu) {
        return r.save(stu);
    }


    public String deletestudent(int id) {
       r.deleteById(id);
       return "deleted suucessfully";
    }


    public String deletedstudentall() {
        r.deleteAll();
        return "deleted all";
    }

    public List<Student> getByGenTech(String tech, String gender) {
        return r.findByTechAndGender(tech,gender);
    }

    public List<Student> getStudentByTech(String tech) {
        return r.findByTech(tech);
    }

    public List<Student> getstudentbyfilter(String gender,String tech) {
        return r.findByGenAndTech(gender,tech);
    }

    public List<Student> getstudentbyjpql(String name) {
        return r.findbyName(name);
    }
}
