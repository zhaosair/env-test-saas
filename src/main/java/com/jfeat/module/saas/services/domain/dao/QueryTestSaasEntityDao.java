package com.jfeat.module.saas.services.domain.dao;

import com.jfeat.module.saas.services.domain.model.TestSaasEntityRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.saas.services.gen.persistence.model.TestSaasEntity;
import com.jfeat.module.saas.services.gen.crud.model.TestSaasEntityModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-06-07
 */
public interface QueryTestSaasEntityDao extends QueryMasterDao<TestSaasEntity> {
   /*
    * Query entity list by page
    */
    List<TestSaasEntityRecord> findTestSaasEntityPage(Page<TestSaasEntityRecord> page, @Param("record") TestSaasEntityRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    TestSaasEntityModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<TestSaasEntityModel> queryMasterModelList(@Param("masterId") Object masterId);
}