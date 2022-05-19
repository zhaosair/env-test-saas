package com.jfeat.module.manymany.services.gen.crud.model;
// this is serviceModel.java.vm




import java.util.List;
import com.jfeat.module.manymany.services.gen.persistence.model.Course;
import com.jfeat.module.manymany.services.gen.persistence.model.Student;

/**
 * Created by Code generator on 2022-05-19
 *  * slaves.size() : 1
 *  * modelpack : import com.jfeat.module.manymany.services.gen.crud.model.StudentModel;
 */
public class StudentModel extends Student{

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
