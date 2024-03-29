package com.jfeat.module.saas.services.domain.service.impl;
import com.jfeat.module.saas.services.domain.service.TestSaasEntityService;
import com.jfeat.module.saas.services.gen.crud.service.impl.CRUDTestSaasEntityServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("testSaasEntityService")
public class TestSaasEntityServiceImpl extends CRUDTestSaasEntityServiceImpl implements TestSaasEntityService {

    @Override
    protected String entityName() {
        return "TestSaasEntity";
    }


                            }
