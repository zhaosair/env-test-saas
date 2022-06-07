
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
import com.jfeat.module.one_many_many.services.domain.dao.QueryCompanyDao;
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
import com.jfeat.module.one_many_many.services.domain.model.CompanyRecord;
import com.jfeat.module.one_many_many.services.gen.crud.model.CompanyModel;
import com.jfeat.module.one_many_many.services.gen.persistence.model.Company;

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
    @Api("Company")
            @RequestMapping("/api/crud/one_many_many/company/companyies")
    public class CompanyOverModelEndpoint {

    @Resource
    CompanyOverModelService companyOverModelService;

    @Resource
    QueryCompanyDao queryCompanyDao;


    // 要查询[从表]关联数据，取消下行注释
    // @Resource
    // QueryDepartmentDao queryDepartmentDao;

    @BusinessLog(name = "Company", value = "create Company")
    @Permission(CompanyPermission.COMPANY_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Company",response = CompanyModel.class)
    public Tip createCompany(@RequestBody CompanyModel entity){
        Integer affected=0;
        try{
                DefaultFilterResult filterResult = new DefaultFilterResult();
            affected= companyOverModelService.createMaster(entity,filterResult,null,null);
            if(affected>0){
               return SuccessTip.create(filterResult.result());
            }
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @BusinessLog(name = "Company", value = "查看 CompanyModel")
    @Permission(CompanyPermission.COMPANY_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Company",response = CompanyModel.class)
    public Tip getCompany(@PathVariable Long id){
    CRUDObject<CompanyModel> entity = companyOverModelService
            .registerQueryMasterDao(queryCompanyDao)
            // 要查询[从表]关联数据，取消下行注释
            //.registerQuerySlaveModelListDao(Department.class, queryDepartmentDao)
            .retrieveMaster(id,null,null,null);

            // sample query for registerQueryMasterDao
            // e.g. <select id="queryMasterModel" resultType="PlanModel">
            //       SELECT t_plan_model.*, t_org.name as orgName
            //       FROM t_plan_model
            //       LEFT JOIN t_org ON t_org.id==t_plan_model.org_id
            //       WHERE t_plan_model.id=#{id}
            //       GROUP BY t_plan_model.id
            //    </select>

            if(entity != null) {
                return SuccessTip.create(entity.toJSONObject());
            } else {
                return SuccessTip.create();
            }

            }

    @BusinessLog(name = "Company", value = "update Company")
    @Permission(CompanyPermission.COMPANY_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Company",response = CompanyModel.class)
    public Tip updateCompany(@PathVariable Long id,@RequestBody CompanyModel entity){
        entity.setId(id);
                // use update flags
            int newOptions = META.UPDATE_CASCADING_DELETION_FLAG;  //default to delete not exist items
            // newOptions = FlagUtil.setFlag(newOptions, META.UPDATE_ALL_COLUMNS_FLAG);

            return SuccessTip.create(companyOverModelService.updateMaster(entity,null,null,null, newOptions));
            }

    @BusinessLog(name = "Company", value = "delete Company")
    @Permission(CompanyPermission.COMPANY_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Company")
    public Tip deleteCompany(@PathVariable Long id){
            return SuccessTip.create(companyOverModelService.deleteMaster(id));
        }

    @Permission(CompanyPermission.COMPANY_VIEW)
    @ApiOperation(value = "Company 列表信息",response = CompanyRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "name", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryCompanyPage(Page<CompanyRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                            @RequestParam(name = "name", required = false) String name,
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

    CompanyRecord record = new CompanyRecord();
                                                                                                                                                                                        record.setName(name);
                        
                                

    List<CompanyRecord> companyPage = queryCompanyDao.findCompanyPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(companyPage);

        return SuccessTip.create(page);
    }
}

