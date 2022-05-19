package com.jfeat.am.module.test.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.test.services.domain.model.StudentRecord;
import com.jfeat.am.module.test.services.gen.crud.model.StudentModel;
import com.jfeat.am.module.test.services.gen.persistence.model.Student;
import com.jfeat.crud.plus.QueryMasterDao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-05-18
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