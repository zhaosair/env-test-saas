package com.jfeat.module.one_many_many.services.domain.service.impl;
import com.jfeat.module.one_many_many.services.domain.service.CompanyOverModelService;
import com.jfeat.module.one_many_many.services.gen.crud.service.impl.CRUDCompanyOverModelServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("companyService")
public class CompanyOverModelServiceImpl extends CRUDCompanyOverModelServiceImpl implements CompanyOverModelService {

    @Override
    protected String entityName() {
        return "Company";
    }


                            }
