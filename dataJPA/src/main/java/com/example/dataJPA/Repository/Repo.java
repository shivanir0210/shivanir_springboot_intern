package com.example.dataJPA.Repository;

import com.example.dataJPA.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.List;

//primary key type is put so integer,student is a entity class
public interface Repo extends JpaRepository <Student,Integer>{
   List<Student> findByTechAndGender(String tech, String gender);

    //Native query --> in tables rows and columns
//JPQL query --> working in entity using field
    //if nothing is mentioned it is JPQL if mentioned native

   List<Student> findByTech(String tech);
    @Query(
            value = "SELECT * FROM student WHERE gender=:gender AND tech=:tech",
            nativeQuery = true
    )
    List<Student> findByGenAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    );


    @Query("SELECT ss from Student ss WHERE ss.name='aswini'")
    List<Student>findbyName(String name);

}
