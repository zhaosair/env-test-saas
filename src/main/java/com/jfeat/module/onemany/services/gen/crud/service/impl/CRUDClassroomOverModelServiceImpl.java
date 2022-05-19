package com.jfeat.module.onemany.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.manymany.services.gen.persistence.dao.StudentMapper;
import com.jfeat.module.manymany.services.gen.persistence.model.Student;
import com.jfeat.module.onemany.services.gen.persistence.model.Classroom;
import com.jfeat.module.onemany.services.gen.persistence.dao.ClassroomMapper;

import com.jfeat.module.onemany.services.gen.crud.service.CRUDClassroomOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;

import javax.annotation.Resource;

import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.module.onemany.services.gen.crud.model.ClassroomModel;

/**
 * <p>
 * implementation
 * </p>
 * CRUDClassroomOverModelService
 *
 * @author Code generator
 * @since 2022-05-19
 */

@Service
public class CRUDClassroomOverModelServiceImpl extends CRUDServiceOverModelImpl<Classroom, ClassroomModel> implements CRUDClassroomOverModelService {


    @Resource
    protected ClassroomMapper classroomMapper;


    @Override
    protected BaseMapper<Classroom> getMasterMapper() {
        return classroomMapper;
    }

    @Override
    protected Class<Classroom> masterClassName() {
        return Classroom.class;
    }

    @Override
    protected Class<ClassroomModel> modelClassName() {
        return ClassroomModel.class;
    }


    @Resource
    private StudentMapper studentMapper;

    private final static String studentFieldName = "id";

    private final static String studentKeyName = "items";


    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                studentKeyName
        };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {


        if (field.compareTo(studentKeyName) == 0) {
            FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(studentFieldName);
            _field.setItemClassName(Student.class);
            _field.setItemMapper(studentMapper);

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


