package com.jfeat.module.one_many_many.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Employee;
import com.jfeat.module.one_many_many.services.gen.persistence.dao.EmployeeMapper;
import com.jfeat.module.one_many_many.services.gen.crud.service.CRUDEmployeeService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDEmployeeService
 * @author Code generator
 * @since 2022-06-07
 */

@Service
public class CRUDEmployeeServiceImpl  extends CRUDServiceOnlyImpl<Employee> implements CRUDEmployeeService {





        @Resource
        protected EmployeeMapper employeeMapper;

        @Override
        protected BaseMapper<Employee> getMasterMapper() {
                return employeeMapper;
        }







}


