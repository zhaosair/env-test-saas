package com.jfeat.module.one_many_many.services.domain.dao;

import com.jfeat.module.one_many_many.services.domain.model.EmployeeRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Employee;
import com.jfeat.module.one_many_many.services.gen.crud.model.EmployeeModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-06-07
 */
public interface QueryEmployeeDao extends QueryMasterDao<Employee> {
   /*
    * Query entity list by page
    */
    List<EmployeeRecord> findEmployeePage(Page<EmployeeRecord> page, @Param("record") EmployeeRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    EmployeeModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<EmployeeModel> queryMasterModelList(@Param("masterId") Object masterId);
}