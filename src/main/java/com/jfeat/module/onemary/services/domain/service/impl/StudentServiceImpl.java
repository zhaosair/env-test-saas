package com.jfeat.module.onemary.services.domain.service.impl;
import com.jfeat.module.onemary.services.domain.service.StudentService;
import com.jfeat.module.onemary.services.gen.crud.service.impl.CRUDStudentServiceImpl;
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
public class StudentServiceImpl extends CRUDStudentServiceImpl implements StudentService {

    @Override
    protected String entityName() {
        return "Student";
    }


                            }
