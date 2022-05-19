package com.jfeat.am.module.test.services.gen.crud.model;
// this is serviceModel.java.vm




import com.jfeat.am.module.test.services.gen.persistence.model.Course;
import com.jfeat.am.module.test.services.gen.persistence.model.Student;

import java.util.List;

/**
 * Created by Code generator on 2022-05-18
 *  * slaves.size() : 1
 *  * modelpack : import com.jfeat.module.cg.test.services.gen.crud.model.StudentModel;
 */
public class StudentModel extends Student {

    // course
    // Course
    // course
    private List<Course> items;

    public List<Course> getItems() {
        return this.items;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }
}
