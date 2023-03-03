package com.jfeat.module.onemanymany.services.domain.dao;

import com.jfeat.module.onemanymany.services.domain.model.CompanyRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.onemanymany.services.gen.persistence.model.Company;
import com.jfeat.module.onemanymany.services.gen.crud.model.CompanyModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-06-07
 */
public interface QueryCompanyDao extends QueryMasterDao<Company> {
   /*
    * Query entity list by page
    */
    List<CompanyRecord> findCompanyPage(Page<CompanyRecord> page, @Param("record") CompanyRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    CompanyModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<CompanyModel> queryMasterModelList(@Param("masterId") Object masterId);
}