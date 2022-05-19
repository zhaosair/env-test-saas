package com.jfeat.am.module.test.services.domain.service.impl;
import com.jfeat.am.module.test.services.domain.service.StudentOverModelService;
import com.jfeat.am.module.test.services.gen.crud.service.impl.CRUDStudentOverModelServiceImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("studentService")
public class StudentOverModelServiceImpl extends CRUDStudentOverModelServiceImpl implements StudentOverModelService {

    @Override
    protected String entityName() {
        return "Student";
    }


                            }
