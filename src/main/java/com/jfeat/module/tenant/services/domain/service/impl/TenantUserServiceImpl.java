package com.jfeat.module.tenant.services.domain.service.impl;
import com.jfeat.module.tenant.services.domain.service.TenantUserService;
import com.jfeat.module.tenant.services.gen.crud.service.impl.CRUDTenantUserServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("tenantUserService")
public class TenantUserServiceImpl extends CRUDTenantUserServiceImpl implements TenantUserService {

    @Override
    protected String entityName() {
        return "TenantUser";
    }


                            }
