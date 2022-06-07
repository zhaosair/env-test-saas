
package com.jfeat.module.one_many_many.api;


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
import com.jfeat.module.one_many_many.services.domain.dao.QueryDepartmentDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.one_many_many.api.permission.*;
import com.jfeat.am.common.annotation.Permission;
import java.math.BigDecimal;

import com.jfeat.module.one_many_many.services.domain.service.*;
import com.jfeat.module.one_many_many.services.domain.model.DepartmentRecord;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Department;

    import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2022-06-07
 */
    @RestController
    @Api("Department")
            @RequestMapping("/api/crud/t_department/department/departments")
    public class DepartmentEndpoint {

    @Resource
    DepartmentService departmentService;

    @Resource
    QueryDepartmentDao queryDepartmentDao;



    @BusinessLog(name = "Department", value = "create Department")
    @Permission(DepartmentPermission.DEPARTMENT_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Department",response = Department.class)
    public Tip createDepartment(@RequestBody Department entity){
        Integer affected=0;
        try{
                affected= departmentService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(DepartmentPermission.DEPARTMENT_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Department",response = Department.class)
    public Tip getDepartment(@PathVariable Long id){
                        return SuccessTip.create(departmentService.queryMasterModel(queryDepartmentDao, id));
            }

    @BusinessLog(name = "Department", value = "update Department")
    @Permission(DepartmentPermission.DEPARTMENT_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Department",response = Department.class)
    public Tip updateDepartment(@PathVariable Long id,@RequestBody Department entity){
        entity.setId(id);
                return SuccessTip.create(departmentService.updateMaster(entity));
            }

    @BusinessLog(name = "Department", value = "delete Department")
    @Permission(DepartmentPermission.DEPARTMENT_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Department")
    public Tip deleteDepartment(@PathVariable Long id){
            return SuccessTip.create(departmentService.deleteMaster(id));
        }

    @Permission(DepartmentPermission.DEPARTMENT_VIEW)
    @ApiOperation(value = "Department 列表信息",response = DepartmentRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "companyId", dataType = "Integer") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryDepartmentPage(Page<DepartmentRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                            @RequestParam(name = "name", required = false) String name,
                    
                                                                                                                                            @RequestParam(name = "companyId", required = false) Integer companyId,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String sortPattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(sortPattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    DepartmentRecord record = new DepartmentRecord();
                                                                                                                                                                                        record.setName(name);
                                                                                                                        record.setCompanyId(companyId);
                        
                                

    List<DepartmentRecord> departmentPage = queryDepartmentDao.findDepartmentPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(departmentPage);

        return SuccessTip.create(page);
    }
}

