
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
import com.jfeat.module.one_many_many.services.domain.dao.QueryEmployeeDao;
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
import com.jfeat.module.one_many_many.services.domain.model.EmployeeRecord;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Employee;

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
    @Api("Employee")
            @RequestMapping("/api/crud/t_employee/employee/employees")
    public class EmployeeEndpoint {

    @Resource
    EmployeeService employeeService;

    @Resource
    QueryEmployeeDao queryEmployeeDao;



    @BusinessLog(name = "Employee", value = "create Employee")
    @Permission(EmployeePermission.EMPLOYEE_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Employee",response = Employee.class)
    public Tip createEmployee(@RequestBody Employee entity){
        Integer affected=0;
        try{
                affected= employeeService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(EmployeePermission.EMPLOYEE_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Employee",response = Employee.class)
    public Tip getEmployee(@PathVariable Long id){
                        return SuccessTip.create(employeeService.queryMasterModel(queryEmployeeDao, id));
            }

    @BusinessLog(name = "Employee", value = "update Employee")
    @Permission(EmployeePermission.EMPLOYEE_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Employee",response = Employee.class)
    public Tip updateEmployee(@PathVariable Long id,@RequestBody Employee entity){
        entity.setId(id);
                return SuccessTip.create(employeeService.updateMaster(entity));
            }

    @BusinessLog(name = "Employee", value = "delete Employee")
    @Permission(EmployeePermission.EMPLOYEE_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Employee")
    public Tip deleteEmployee(@PathVariable Long id){
            return SuccessTip.create(employeeService.deleteMaster(id));
        }

    @Permission(EmployeePermission.EMPLOYEE_VIEW)
    @ApiOperation(value = "Employee 列表信息",response = EmployeeRecord.class)
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
    public Tip queryEmployeePage(Page<EmployeeRecord> page,
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

    EmployeeRecord record = new EmployeeRecord();
                                                                                                                                                                                        record.setName(name);
                                                                                                                        record.setCompanyId(companyId);
                        
                                

    List<EmployeeRecord> employeePage = queryEmployeeDao.findEmployeePage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(employeePage);

        return SuccessTip.create(page);
    }
}

