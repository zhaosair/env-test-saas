package com.jfeat.module.manymany.services.domain.dao;

import com.jfeat.module.manymany.services.domain.model.StudentRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.manymany.services.gen.persistence.model.Student;
import com.jfeat.module.manymany.services.gen.crud.model.StudentModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-05-19
 */
public interface QueryStudentDao extends QueryMasterDao<Student> {
   /*
    * Query entity list by page
    */
    List<StudentRecord> findStudentPage(Page<StudentRecord> page, @Param("record") StudentRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    StudentModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<StudentModel> queryMasterModelList(@Param("masterId") Object masterId);
}