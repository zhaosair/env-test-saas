
package com.jfeat.module.onemary.api;


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
import com.jfeat.module.onemary.services.domain.dao.QueryStudentDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.onemary.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.module.onemary.services.domain.service.*;
import com.jfeat.module.onemary.services.domain.model.StudentRecord;
import com.jfeat.module.onemary.services.gen.persistence.model.Student;

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
 * @since 2022-05-23
 */
@RestController
@Api("Student")
@RequestMapping("/api/crud/onemary/student/students")
public class StudentEndpoint {

    @Resource
    StudentService studentService;

    @Resource
    QueryStudentDao queryStudentDao;


    @BusinessLog(name = "Student", value = "create Student")
    @Permission(StudentPermission.STUDENT_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Student", response = Student.class)
    public Tip createStudent(@RequestBody Student entity) {
        Integer affected = 0;
        try {
            affected = studentService.createMaster(entity);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(StudentPermission.STUDENT_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Student", response = Student.class)
    public Tip getStudent(@PathVariable Long id) {
        return SuccessTip.create(studentService.queryMasterModel(queryStudentDao, id));
    }

    @BusinessLog(name = "Student", value = "update Student")
    @Permission(StudentPermission.STUDENT_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Student", response = Student.class)
    public Tip updateStudent(@PathVariable Long id, @RequestBody Student entity) {
        entity.setId(Math.toIntExact(id));
        return SuccessTip.create(studentService.updateMaster(entity));
    }

    @BusinessLog(name = "Student", value = "delete Student")
    @Permission(StudentPermission.STUDENT_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Student")
    public Tip deleteStudent(@PathVariable Long id) {
        return SuccessTip.create(studentService.deleteMaster(id));
    }

    @Permission(StudentPermission.STUDENT_VIEW)
    @ApiOperation(value = "Student 列表信息", response = StudentRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "classroomId", dataType = "Integer"),
            @ApiImplicitParam(name = "address", dataType = "String"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryStudentPage(Page<StudentRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                // for tag feature query
                                @RequestParam(name = "tag", required = false) String tag,
                                // end tag
                                @RequestParam(name = "search", required = false) String search,

                                @RequestParam(name = "name", required = false) String name,

                                @RequestParam(name = "classroomId", required = false) Integer classroomId,

                                @RequestParam(name = "address", required = false) String address,
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

        StudentRecord record = new StudentRecord();
        record.setName(name);
        record.setClassroomId(classroomId);
        record.setAddress(address);


        List<StudentRecord> studentPage = queryStudentDao.findStudentPage(page, record, tag, search, orderBy, null, null);


        page.setRecords(studentPage);

        return SuccessTip.create(page);
    }
}

