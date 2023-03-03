package com.jfeat.module.onemanymany.services.domain.dao;

import com.jfeat.module.onemanymany.services.domain.model.DepartmentRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.onemanymany.services.gen.persistence.model.Department;
import com.jfeat.module.onemanymany.services.gen.crud.model.DepartmentModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-06-07
 */
public interface QueryDepartmentDao extends QueryMasterDao<Department> {
   /*
    * Query entity list by page
    */
    List<DepartmentRecord> findDepartmentPage(Page<DepartmentRecord> page, @Param("record") DepartmentRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    DepartmentModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<DepartmentModel> queryMasterModelList(@Param("masterId") Object masterId);
}