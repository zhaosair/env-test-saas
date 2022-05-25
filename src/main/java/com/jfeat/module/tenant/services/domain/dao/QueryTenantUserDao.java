package com.jfeat.module.tenant.services.domain.dao;

import com.jfeat.module.tenant.services.domain.model.TenantUserRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.tenant.services.gen.persistence.model.TenantUser;
import com.jfeat.module.tenant.services.gen.crud.model.TenantUserModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-05-24
 */
public interface QueryTenantUserDao extends QueryMasterDao<TenantUser> {
   /*
    * Query entity list by page
    */
    List<TenantUserRecord> findTenantUserPage(Page<TenantUserRecord> page, @Param("record") TenantUserRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    TenantUserModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<TenantUserModel> queryMasterModelList(@Param("masterId") Object masterId);
}