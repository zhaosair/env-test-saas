package com.jfeat.am.module.test.services.gen.crud.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.am.module.test.services.gen.crud.service.CRUDTestSaasEntityService;
import com.jfeat.am.module.test.services.gen.persistence.dao.TestSaasEntityMapper;
import com.jfeat.am.module.test.services.gen.persistence.model.TestSaasEntity;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDTestSaasEntityService
 * @author Code Generator
 * @since 2019-02-13
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


