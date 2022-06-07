package com.jfeat.module.one_many_many.services.domain.service.impl;
import com.jfeat.module.one_many_many.services.domain.service.DepartmentService;
import com.jfeat.module.one_many_many.services.gen.crud.service.impl.CRUDDepartmentServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("departmentService")
public class DepartmentServiceImpl extends CRUDDepartmentServiceImpl implements DepartmentService {

    @Override
    protected String entityName() {
        return "Department";
    }


                            }
