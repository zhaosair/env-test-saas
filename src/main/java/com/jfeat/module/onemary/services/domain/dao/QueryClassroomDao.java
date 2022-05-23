package com.jfeat.module.onemary.services.domain.dao;

import com.jfeat.module.onemary.services.domain.model.ClassroomRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.onemary.services.gen.persistence.model.Classroom;
import com.jfeat.module.onemary.services.gen.crud.model.ClassroomModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-05-23
 */
public interface QueryClassroomDao extends QueryMasterDao<Classroom> {
   /*
    * Query entity list by page
    */
    List<ClassroomRecord> findClassroomPage(Page<ClassroomRecord> page, @Param("record") ClassroomRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    ClassroomModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ClassroomModel> queryMasterModelList(@Param("masterId") Object masterId);
}