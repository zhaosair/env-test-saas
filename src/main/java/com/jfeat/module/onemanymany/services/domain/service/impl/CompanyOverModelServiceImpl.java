package com.jfeat.module.onemanymany.services.domain.service.impl;
import com.jfeat.module.onemanymany.services.domain.service.CompanyOverModelService;
import com.jfeat.module.onemanymany.services.gen.crud.service.impl.CRUDCompanyOverModelServiceImpl;
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
