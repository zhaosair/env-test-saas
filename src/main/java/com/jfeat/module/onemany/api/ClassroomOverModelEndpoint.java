
package com.jfeat.module.onemany.api;


import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.module.onemany.services.domain.dao.QueryClassroomDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.onemany.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import com.jfeat.module.onemany.services.domain.service.*;
import com.jfeat.module.onemany.services.domain.model.ClassroomRecord;
import com.jfeat.module.onemany.services.gen.crud.model.ClassroomModel;
import com.jfeat.module.onemany.services.gen.persistence.model.Classroom;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2022-05-19
 */
@RestController
@Api("Classroom")
@RequestMapping("/api/crud/onemany/classroom/classrooms")
public class ClassroomOverModelEndpoint {

    @Resource
    ClassroomOverModelService classroomOverModelService;

    @Resource
    QueryClassroomDao queryClassroomDao;


    // 要查询[从表]关联数据，取消下行注释
    // @Resource
    // QueryStudentDao queryStudentDao;

    @BusinessLog(name = "Classroom", value = "create Classroom")
    @Permission(ClassroomPermission.CLASSROOM_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Classroom", response = ClassroomModel.class)
    public Tip createClassroom(@RequestBody ClassroomModel entity) {
        Integer affected = 0;
        try {
            DefaultFilterResult filterResult = new DefaultFilterResult();
            affected = classroomOverModelService.createMaster(entity, filterResult, null, null);
            if (affected > 0) {
                return SuccessTip.create(filterResult.result());
            }
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "Classroom", value = "查看 ClassroomModel")
    @Permission(ClassroomPermission.CLASSROOM_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Classroom", response = ClassroomModel.class)
    public Tip getClassroom(@PathVariable Long id) {
        CRUDObject<ClassroomModel> entity = classroomOverModelService
                .registerQueryMasterDao(queryClassroomDao)
                // 要查询[从表]关联数据，取消下行注释
                //.registerQuerySlaveModelListDao(Student.class, queryStudentDao)
                .retrieveMaster(id, null, null, null);

        // sample query for registerQueryMasterDao
        // e.g. <select id="queryMasterModel" resultType="PlanModel">
        //       SELECT t_plan_model.*, t_org.name as orgName
        //       FROM t_plan_model
        //       LEFT JOIN t_org ON t_org.id==t_plan_model.org_id
        //       WHERE t_plan_model.id=#{id}
        //       GROUP BY t_plan_model.id
        //    </select>

        if (entity != null) {
            return SuccessTip.create(entity.toJSONObject());
        } else {
            return SuccessTip.create();
        }

    }

    @BusinessLog(name = "Classroom", value = "update Classroom")
    @Permission(ClassroomPermission.CLASSROOM_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Classroom", response = ClassroomModel.class)
    public Tip updateClassroom(@PathVariable Long id, @RequestBody ClassroomModel entity) {
        entity.setId(id);
        // use update flags
        int newOptions = META.UPDATE_CASCADING_DELETION_FLAG;  //default to delete not exist items
        // newOptions = FlagUtil.setFlag(newOptions, META.UPDATE_ALL_COLUMNS_FLAG);

        return SuccessTip.create(classroomOverModelService.updateMaster(entity, null, null, null, newOptions));
    }

    @BusinessLog(name = "Classroom", value = "delete Classroom")
    @Permission(ClassroomPermission.CLASSROOM_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Classroom")
    public Tip deleteClassroom(@PathVariable Long id) {
        return SuccessTip.create(classroomOverModelService.deleteMaster(id));
    }

    @Permission(ClassroomPermission.CLASSROOM_VIEW)
    @ApiOperation(value = "Classroom 列表信息", response = ClassroomRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryClassroomPage(Page<ClassroomRecord> page,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  // for tag feature query
                                  @RequestParam(name = "tag", required = false) String tag,
                                  // end tag
                                  @RequestParam(name = "search", required = false) String search,

                                  @RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "orderBy", required = false) String orderBy,
                                  @RequestParam(name = "sort", required = false) String sort) {

        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String sortPattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(sortPattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        ClassroomRecord record = new ClassroomRecord();
        record.setName(name);


        List<ClassroomRecord> classroomPage = queryClassroomDao.findClassroomPage(page, record, tag, search, orderBy, null, null);


        page.setRecords(classroomPage);

        return SuccessTip.create(page);
    }
}

