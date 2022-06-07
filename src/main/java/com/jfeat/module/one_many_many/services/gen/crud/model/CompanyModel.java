package com.jfeat.module.one_many_many.services.gen.crud.model;
// this is serviceModel.java.vm




import java.util.List;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Department;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Employee;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Company;

/**
 * Created by Code generator on 2022-06-07
 *  * slaves.size() : 2
 *  * modelpack : import com.jfeat.module.one_many_many.services.gen.crud.model.CompanyModel;
 */
public class CompanyModel extends Company{
    private List<Department> departments;

    // department
    // Department
    // department
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    private List<Employee> employees;

    // employee
    // Employee
    // employee
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
