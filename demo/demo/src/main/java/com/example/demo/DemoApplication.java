package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(DemoApplication.class, args);
        Student s1=context.getBean(Student.class);

        s1.study();
//        s1.age=21;
//        Student s2=context.getBean(Student.class);
//        System.out.println(s1.age +" "+s2.age);
        s1.writeexam();


	}

}
