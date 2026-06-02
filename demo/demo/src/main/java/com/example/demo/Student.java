package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//singleton mean scope spring return the same object evertime
//prototype mean spring creates new object every time
@Scope("prototype")
@Component
public class Student {
    int age;

    // ---> Field injection
//    @Autowired
     //Pen p;

        // --> constructor injection
//@Autowired
//Pen p;
//    public Student(Pen p) {
//        this.p=p;
//    }

    // --> Setter injection

//    Pen p;
//    @Autowired
//    public void setPen(Pen p) {
//        this.p=p;
//    }
    @Autowired
    @Qualifier("Pencil")
    Writer w;
    public void study()
    {

        System.out.println("this is from student class");
    }
    public  Student()
    {

        System.out.println("Student Constructor");
    }
    public void writeexam()
    {
        w.write();
    }
}
