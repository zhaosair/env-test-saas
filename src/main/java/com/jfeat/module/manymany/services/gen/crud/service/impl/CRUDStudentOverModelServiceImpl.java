package com.jfeat.module.manymany.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.manymany.services.gen.persistence.model.Student;
import com.jfeat.module.manymany.services.gen.persistence.dao.StudentMapper;
import com.jfeat.module.manymany.services.gen.persistence.dao.CourseMapper;
import com.jfeat.module.manymany.services.gen.persistence.model.Course;
import com.jfeat.module.manymany.services.gen.persistence.dao.StuCourMapper;
import com.jfeat.module.manymany.services.gen.persistence.model.StuCour;

import com.jfeat.module.manymany.services.gen.crud.service.CRUDStudentOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;

import javax.annotation.Resource;

import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.module.manymany.services.gen.crud.model.StudentModel;

/**
 * <p>
 * implementation
 * </p>
 * CRUDStudentOverModelService
 *
 * @author Code generator
 * @since 2022-05-19
 */

@Service
public class CRUDStudentOverModelServiceImpl extends CRUDServiceOverModelImpl<Student, StudentModel> implements CRUDStudentOverModelService {


    @Resource
    protected StudentMapper studentMapper;


    @Override
    protected BaseMapper<Student> getMasterMapper() {
        return studentMapper;
    }

    @Override
    protected Class<Student> masterClassName() {
        return Student.class;
    }

    @Override
    protected Class<StudentModel> modelClassName() {
        return StudentModel.class;
    }


    @Resource
    private CourseMapper courseMapper;

    private final static String courseFieldName = "t_stu_cour::id:id";

    private final static String courseKeyName = "items";


    // relation mapper (one many peer)
    @Resource
    private StuCourMapper stuCourMapper;


    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                courseKeyName
        };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {


        if (field.compareTo(courseKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(courseFieldName);
            _field.setItemClassName(Course.class);
            _field.setItemMapper(courseMapper);
            // one many by peer
            _field.setItemRelationMapper(stuCourMapper);
            _field.setItemRelationClassName(StuCour.class);

            return _field;
        }


        throw new BusinessException(BusinessCode.BadRequest);
    }


    @Override
    protected String[] childFieldNames() {
        return new String[]{
        };
    }

    @Override
    protected FIELD onChildFieldItem(String field) {

        throw new BusinessException(BusinessCode.BadRequest);
    }


}


