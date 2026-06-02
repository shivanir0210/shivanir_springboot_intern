package com.eduhub.eduhub_backend.component;

import org.springframework.stereotype.Component;

@Component
public class Course {
    public int id;
    public String subjectName;
    public int credits;
    public Course() {
    }
    public Course(int id, String subjectName, int credits) {
        this.id = id;
        this.subjectName = subjectName;
        this.credits = credits;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
