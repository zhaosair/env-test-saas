package com.jfeat.am.module.test.services.gen.crud.model;
// this is serviceModel.java.vm


import com.jfeat.am.module.test.services.gen.persistence.model.Classroom;
import com.jfeat.am.module.test.services.gen.persistence.model.Student;


import java.util.List;

/**
 * Created by Code generator on 2022-05-18
 *  * slaves.size() : 1
 *  * modelpack : import com.jfeat.module.cg.test.services.gen.crud.model.ClassroomModel;
 */
public class ClassroomModel extends Classroom {

    // student
    // Student
    // student
    private List<Student> items;

    public List<Student> getItems() {
        return this.items;
    }

    public void setItems(List<Student> items) {
        this.items = items;
    }
}
