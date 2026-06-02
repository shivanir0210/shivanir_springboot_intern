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
}
