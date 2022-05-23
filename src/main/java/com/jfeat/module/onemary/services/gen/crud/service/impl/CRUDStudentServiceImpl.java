package com.jfeat.module.onemary.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.onemary.services.gen.persistence.model.Student;
import com.jfeat.module.onemary.services.gen.persistence.dao.StudentMapper;
import com.jfeat.module.onemary.services.gen.crud.service.CRUDStudentService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDStudentService
 * @author Code generator
 * @since 2022-05-23
 */

@Service
public class CRUDStudentServiceImpl  extends CRUDServiceOnlyImpl<Student> implements CRUDStudentService {





        @Resource
        protected StudentMapper studentMapper;

        @Override
        protected BaseMapper<Student> getMasterMapper() {
                return studentMapper;
        }







}


