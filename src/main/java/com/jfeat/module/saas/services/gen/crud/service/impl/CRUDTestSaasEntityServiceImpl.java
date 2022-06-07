package com.jfeat.module.saas.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.module.saas.services.gen.persistence.model.TestSaasEntity;
import com.jfeat.module.saas.services.gen.persistence.dao.TestSaasEntityMapper;
import com.jfeat.module.saas.services.gen.crud.service.CRUDTestSaasEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTestSaasEntityService
 * @author Code generator
 * @since 2022-06-07
 */

@Service
public class CRUDTestSaasEntityServiceImpl  extends CRUDServiceOnlyImpl<TestSaasEntity> implements CRUDTestSaasEntityService {





        @Resource
        protected TestSaasEntityMapper testSaasEntityMapper;

        @Override
        protected BaseMapper<TestSaasEntity> getMasterMapper() {
                return testSaasEntityMapper;
        }







}


