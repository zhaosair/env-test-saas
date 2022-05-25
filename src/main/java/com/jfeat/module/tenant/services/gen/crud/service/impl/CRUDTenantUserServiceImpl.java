package com.jfeat.module.tenant.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.tenant.services.gen.persistence.model.TenantUser;
import com.jfeat.module.tenant.services.gen.persistence.dao.TenantUserMapper;
import com.jfeat.module.tenant.services.gen.crud.service.CRUDTenantUserService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTenantUserService
 * @author Code generator
 * @since 2022-05-24
 */

@Service
public class CRUDTenantUserServiceImpl  extends CRUDServiceOnlyImpl<TenantUser> implements CRUDTenantUserService {





        @Resource
        protected TenantUserMapper tenantUserMapper;

        @Override
        protected BaseMapper<TenantUser> getMasterMapper() {
                return tenantUserMapper;
        }







}


