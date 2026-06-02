package com.example.dataJPA.Repository;

import com.example.dataJPA.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository <Student,Integer>{
}
