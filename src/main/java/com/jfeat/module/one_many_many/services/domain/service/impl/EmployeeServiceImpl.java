package com.jfeat.module.one_many_many.services.domain.service.impl;
import com.jfeat.module.one_many_many.services.domain.service.EmployeeService;
import com.jfeat.module.one_many_many.services.gen.crud.service.impl.CRUDEmployeeServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("employeeService")
public class EmployeeServiceImpl extends CRUDEmployeeServiceImpl implements EmployeeService {

    @Override
    protected String entityName() {
        return "Employee";
    }


                            }
