package com.jfeat.module.manymany.services.domain.model;

import com.jfeat.module.manymany.services.gen.persistence.model.Course;
import com.jfeat.module.manymany.services.gen.persistence.model.Student;

/**
 * Created by Code generator on 2022-05-19
 */
public class StudentRecord extends Student{
    private Course course;

    public Course getCourse() {
        return course;
    }

    public StudentRecord setCourse(Course course) {
        this.course = course;
        return this;
    }
}
