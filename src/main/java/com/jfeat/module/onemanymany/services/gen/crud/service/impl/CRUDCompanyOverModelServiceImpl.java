package com.jfeat.module.onemanymany.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.onemanymany.services.gen.persistence.model.Company;
import com.jfeat.module.onemanymany.services.gen.persistence.dao.CompanyMapper;
import com.jfeat.module.onemanymany.services.gen.persistence.dao.DepartmentMapper;
import com.jfeat.module.onemanymany.services.gen.persistence.model.Department;
    
import com.jfeat.module.onemanymany.services.gen.persistence.dao.EmployeeMapper;
import com.jfeat.module.onemanymany.services.gen.persistence.model.Employee;
    
import com.jfeat.module.onemanymany.services.gen.crud.service.CRUDCompanyOverModelService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOverModelImpl;
import com.jfeat.module.onemanymany.services.gen.crud.model.CompanyModel;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDCompanyOverModelService
 * @author Code generator
 * @since 2022-06-07
 */

@Service
public class CRUDCompanyOverModelServiceImpl  extends CRUDServiceOverModelImpl<Company,CompanyModel> implements CRUDCompanyOverModelService {









    @Resource
    protected CompanyMapper companyMapper;

    
    @Override
    protected BaseMapper<Company> getMasterMapper() {
        return companyMapper;
    }

    @Override
    protected Class<Company> masterClassName() {
        return Company.class;
    }

    @Override
    protected Class<CompanyModel> modelClassName() {
        return CompanyModel.class;
    }



    
    @Resource
    private DepartmentMapper departmentMapper;

                        private final static String departmentFieldName = "company_id";
    
    
                private final static String departmentKeyName = "departments";
    
    @Resource
    private EmployeeMapper employeeMapper;

        private final static String employeeFieldName = "company_id";
      
        private final static String employeeKeyName = "employees";
                   
    

    
    @Override
    protected String[] slaveFieldNames() {
        return new String[]{
                                             departmentKeyName
                                                                 ,employeeKeyName
                            };
    }

    @Override
    protected FIELD onSlaveFieldItem(String field) {

        
                                                
            if (field.compareTo(departmentKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(departmentFieldName);
            _field.setItemClassName(Department.class);
            _field.setItemMapper(departmentMapper);
            
            return _field;
        }


            
                                                
            else if (field.compareTo(employeeKeyName) == 0) {
                FIELD _field = new FIELD();
            _field.setItemKeyName(field);
            _field.setItemFieldName(employeeFieldName);
            _field.setItemClassName(Employee.class);
            _field.setItemMapper(employeeMapper);
            
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


