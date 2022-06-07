package com.jfeat.module.onemary_teacher.services.gen.crud.model;
// this is serviceModel.java.vm




import java.util.List;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Student;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Teacher;
import com.jfeat.module.onemary_teacher.services.gen.persistence.model.Classroom;

/**
 * Created by Code generator on 2022-06-07
 *  * slaves.size() : 2
 *  * modelpack : import com.jfeat.module.onemary_teacher.services.gen.crud.model.ClassroomModel;
 */
public class ClassroomModel extends Classroom{
    private List<Student> students;

    // student
    // Student
    // student
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    private List<Teacher> teachers;

    // teacher
    // Teacher
    // teacher
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
