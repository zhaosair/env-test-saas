package com.jfeat.module.onemany.services.gen.crud.model;
// this is serviceModel.java.vm




import java.util.List;

import com.jfeat.module.manymany.services.gen.persistence.model.Student;
import com.jfeat.module.onemany.services.gen.persistence.model.Classroom;

/**
 * Created by Code generator on 2022-05-19
 *  * slaves.size() : 1
 *  * modelpack : import com.jfeat.module.onemany.services.gen.crud.model.ClassroomModel;
 */
public class ClassroomModel extends Classroom{

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
