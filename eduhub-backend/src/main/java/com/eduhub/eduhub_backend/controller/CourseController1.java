package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//if we have multiple controller it is confused which to choose we use @RequestMapping("/course")
//@RestController
//public class CourseController1 {
//    @GetMapping("course")
//    public ResponseEntity<List<Course>> getCourse() {
//        List<Course> courses = new ArrayList<>();
//        courses.add(new Course(1,"maths",4));
//        courses.add(new Course(2,"phy",3));
//        courses.add(new Course(3,"chemistry",4));
//        courses.add(new Course(4,"science",5));
//        courses.add(new Course(5,"eng",4));
//        return ResponseEntity.ok(courses);
//    }
//
////to get the particular course
//    @GetMapping("course/{id}/{subjectName}/{credits}")
//    public ResponseEntity<Course>getCourse(@PathVariable int id, @PathVariable String subjectName, @PathVariable int credits) {
//        Course course = new Course(id,subjectName,credits);
//        return ResponseEntity.ok(course);
//    }
////  return returnCourseList.stream()
////        .filter(c -> c.getCourseCode().equalsIgnoreCase(code))
////        .findFirst()
////        .map(ResponseEntity::ok)
////        .orElse(ResponseEntity.notFound().build());
//
//    //use of  pathVaraible and Requestparam to get the course
//    //http://localhost:8080/query?id=2&subjectName=phy&credits=3
//    @GetMapping("Course/query")
//    public ResponseEntity<Course> getCoursebyid(@RequestParam int id,@RequestParam String subjectName,@RequestParam int credits) {
//        Course course=new Course(id,subjectName,credits);
//        return ResponseEntity.ok(course);
//    }
//    @PostMapping("course/create")
//    public ResponseEntity<List<Course>>createCourse(@RequestBody List <Course> course)
//    {
//        for(Course c:course) {
//            System.out.println(c.getId());
//            System.out.println(c.getSubjectName());
//            System.out.println(c.getCredits());
//        }
//        return ResponseEntity.ok(course);
//    }
//
//    @PutMapping("/update/{code}")
//    public ResponseEntity<Course> updateCourse(
//            @PathVariable String code,
//            @RequestBody Course updatedCourse) {
//        Course Course=courses.stream
//    }
//
//    @DeleteMapping("course/{id}")
//    public ResponseEntity<String> deleteCourse(
//            @PathVariable int id)
//    {
//        return ResponseEntity.ok("Course deleted successfully");
//    }
    @RequestMapping("course")
        @RestController
        public class CourseController1 {

            static List<Course> courses = new ArrayList<>();

            static {
                courses.add(new Course(1,"maths",4));
                courses.add(new Course(2,"phy",3));
                courses.add(new Course(3,"chemistry",4));
                courses.add(new Course(4,"science",5));
                courses.add(new Course(5,"eng",4));
            }

            @GetMapping("course")
            public ResponseEntity<List<Course>> getCourse() {
                return ResponseEntity.ok(courses);
            }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable int id) {

        Course course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course", "id", String.valueOf(id))
                );

        return ResponseEntity.ok(course);
    }
    //http://localhost:8080/query?id=2&subjectName=phy&credits=3
//          @GetMapping("Course/query")
//          public ResponseEntity<Course> getCoursebyid(@RequestParam int id,@RequestParam String subjectName,@RequestParam int credits) {
//        Course course=new Course(id,subjectName,credits);
//        return ResponseEntity.ok(course);
//    }

    @PutMapping("query/{id}")
    public String updateCourse( @PathVariable String id) throws Exception{
                if(id.startsWith("**"))
                {
                    throw new IllegalArgumentException("Ids cannot start with *");
                }
                else if(id.startsWith("*"))
                {
                    throw new Exception("nothing to update");
                }
                return id;

    }
            @PutMapping("/update/{id}")
            public ResponseEntity<Course> updateCourse(
                    @PathVariable int id,
                    @RequestBody Course updatedCourse) {

                Course course = courses.stream()
                        .filter(c -> c.getId() == id)
                        .findFirst()
                        .orElseThrow(() ->
                        new ResourceNotFoundException("Course", "id", String.valueOf(id))
                );

                course.setSubjectName(updatedCourse.getSubjectName());
                course.setCredits(updatedCourse.getCredits());

                return ResponseEntity.ok(course);
            }
    @DeleteMapping("course/{id}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable int id) {

        Course course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        courses.remove(course);

        return ResponseEntity.ok("Course deleted successfully");
    }
        }


