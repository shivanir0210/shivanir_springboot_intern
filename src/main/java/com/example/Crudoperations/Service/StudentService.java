package com.example.Crudoperations.Service;

import com.example.Crudoperations.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class StudentService {

    List<Student> student = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "shiva", "sb"),
                    new Student(2, "dhanu", "react")
            )
    );

    public List<Student> getstudents() {

        return student;
    }

    public Student getStudentsbyid(int id) {
//        return student.get(id);
        //this will return by id if user not available return first one
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getId() == id) {
                index = i;
                flag = false;
            }
        }
        if (flag) return new Student(0, "", "");
        else {
            return student.get(index);
        }
    }

    public void addstudent(Student stud) {
        student.add(stud);
    }

    public String updatestidentbyid(int id, Student stud)
    {
        for(int i = 0; i < student.size(); i++)
        {
            if(student.get(i).getId() == id)
            {
                stud.setId(id);
                student.set(i, stud);
                return "Student updated successfully";
            }
        }

        return "Student with id " + id + " not found";
    }


    public String deletestudents(int id) {
        boolean flag=true;
        int index=0;
        for(int i=0;i<student.size();i++)
        {
            if(student.get(i).getId()==id)
            {
                index=i;
                flag=false;
                break;
            }
        }
        if(!flag)return "no such user";
        else {
            student.remove(index);
            return "deleted sucessfully";
        }

    }
}

