package com.jfeat.module.one_many_many.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Department;
import com.jfeat.module.one_many_many.services.gen.persistence.dao.DepartmentMapper;
import com.jfeat.module.one_many_many.services.gen.crud.service.CRUDDepartmentService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDDepartmentService
 * @author Code generator
 * @since 2022-06-07
 */

@Service
public class CRUDDepartmentServiceImpl  extends CRUDServiceOnlyImpl<Department> implements CRUDDepartmentService {





        @Resource
        protected DepartmentMapper departmentMapper;

        @Override
        protected BaseMapper<Department> getMasterMapper() {
                return departmentMapper;
        }







}


