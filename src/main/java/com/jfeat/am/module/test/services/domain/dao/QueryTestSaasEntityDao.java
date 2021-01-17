package com.jfeat.am.module.test.services.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.test.services.domain.model.TestSaasEntityRecord;

import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.test.services.gen.persistence.model.TestSaasEntity;
import java.util.List;

/**
 * Created by Code Generator on 2019-02-13
 */
public interface QueryTestSaasEntityDao extends BaseMapper<TestSaasEntity> {
    List<TestSaasEntityRecord> findTestSaasEntityPage(Page<TestSaasEntityRecord> page, @Param("record") TestSaasEntityRecord record, @Param("search") String search, @Param("orderBy") String orderBy);
}