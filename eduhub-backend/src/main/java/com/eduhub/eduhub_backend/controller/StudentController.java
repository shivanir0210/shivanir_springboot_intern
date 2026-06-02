package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "shivani", "R");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "shivani", "R"));
        studentList.add(new Student(2, "shiva", "R"));
        studentList.add(new Student(3, "abi", "R"));
        studentList.add(new Student(4, "varni", "M"));
        studentList.add(new Student(5, "dhanu", "R"));
return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
//http://localhost:8080/5/shivani/R
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student>StudentPathVaraible(@PathVariable int id, @PathVariable ("first-name")String firstName, @PathVariable ("last-name")String lastName) {
        Student Student =new Student(id,firstName,lastName);
        return new ResponseEntity<>(Student , HttpStatus.OK);
    }
//    http://localhost:8080/query?id=1&firstName=shivani&lastName=R
@GetMapping("query")
    public ResponseEntity<Student>studentRequestVaraible(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName) {
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }
    @PostMapping("create")
    public ResponseEntity<Student>createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student>updateStudent(@RequestBody Student student) {
        return ResponseEntity.accepted().body(student);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity updateStudent(@PathVariable ("id")int id) {
        return ResponseEntity.accepted().body("data returned sucessfuly");
    }

}

